import br.com.tonni.adapters.AdressJpaAdapter;
import br.com.tonni.adapters.LocationFromGoogle;
import br.com.tonni.configuration.AdressConfig;
import br.com.tonni.controller.AdressRestController;
import br.com.tonni.data.AdressDto;
import br.com.tonni.entity.Adress;
import br.com.tonni.repository.AdressRepository;
import br.com.tonni.service.AdressServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-integration-tests.properties")
public class AddressCrudTest {

	@Mock
	private AdressRepository adressRepository;

	@InjectMocks
	private AdressJpaAdapter adressJpaAdapter;

	@InjectMocks
	private LocationFromGoogle locationFromGoogle;

	@InjectMocks
	private AdressRestController adressRestController;

	private MockAdressDto mockAdressDto;
	private MockAdress mockAdress;

	private AdressServiceImpl adressService;

	/* Configura os mocks dos retornos das camadas DAO */
	@Before
	public void setup() throws SQLException {
		adressJpaAdapter = new AdressJpaAdapter();

		locationFromGoogle = new LocationFromGoogle();

		this.adressService = new AdressServiceImpl(this.adressJpaAdapter, this.locationFromGoogle);

		this.adressRestController = new AdressRestController(this.adressService);

		this.mockAdressDto = new MockAdressDto();
		this.mockAdress = new MockAdress();

		/* AdressDto - Mocka o retorno simulando uma consulta com parametros usuario pai */
		Adress address = mockAdress.createRequest().get(0);
		Mockito.when(adressRepository.save(Mockito.any(Adress.class))).thenReturn(address);

		Adress addressUpdate = mockAdress.createRequest().get(0);
		addressUpdate.setStreetName("street-update");
		Mockito.when(adressRepository.save(Mockito.any(Adress.class))).thenReturn(addressUpdate);

//		List<Adress> listAddress = mockAdress.createRequest();

//		Mockito.when(adressRepository.delete(Mockito.any(Adress.class))).thenReturn(addressUpdate);
//
//		//* AdressDto - Mocka o retorno simulando uma consulta com parametros usuario pai */
//		Optional<Adress> adress = Optional.ofNullable(mockAdress.createRequest().get(0));
//		Mockito.when(adressRepository.findById(Mockito.anyLong())).thenReturn(adress);
//
//		Mockito.when(adressRepository.findById(Mockito.anyLong())).thenReturn(adress);

	}

	@Test
	public void deveInserirUmEndereco()  {
		AdressDto adressDto = this.mockAdressDto.createRequestDTO().get(0);

		AdressDto requestDTO = this.adressRestController.createAdress(adressDto);

		Assert.assertNotNull(requestDTO);
		Assert.assertEquals(new Long(1L), requestDTO.getId());
	}


		
}
