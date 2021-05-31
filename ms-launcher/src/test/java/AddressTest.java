import br.com.tonni.adapters.AdressJpaAdapter;
import br.com.tonni.adapters.LocationFromGoogle;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={br.com.tonni.AdressApplication.class})
@TestPropertySource(locations = "classpath:application-integration-tests.properties")
public class AddressTest {

	@Mock
	private AdressRepository adressRepository;

	@InjectMocks
	private AdressJpaAdapter adressJpaAdapter;

	@Autowired
	private LocationFromGoogle locationFromGoogle;

	@InjectMocks
	private AdressRestController adressRestController;

	private MockAdressDto mockAdressDto;
	private MockAdress mockAdress;

	private AdressServiceImpl adressService;

	/* Configura os mocks dos retornos das camadas DAO */
	@Before
	public void setup() throws SQLException {
		adressService = new AdressServiceImpl(adressJpaAdapter, locationFromGoogle);

        adressRestController = new AdressRestController(adressService);

		mockAdressDto = new MockAdressDto();
		mockAdress = new MockAdress();

		/* AdressDto - Mocka o retorno simulando uma consulta com parametros usuario pai */
		List<Adress> listAddress = mockAdress.createRequest();
		Mockito.when(adressRepository.findAll()).thenReturn(listAddress);

		//* AdressDto - Mocka o retorno simulando uma consulta com parametros usuario pai */
		Optional<Adress> adress = Optional.ofNullable(mockAdress.createRequest().get(0));
		Mockito.when(adressRepository.findById(Mockito.anyLong())).thenReturn(adress);

		//* AdressDto - Mocka o retorno simulando uma consulta com parametros usuario pai */
		Adress adressSaved = mockAdress.createRequest().get(0);
		Mockito.when(adressRepository.save(Mockito.any(Adress.class))).thenReturn(adressSaved);

//		AdressDto adressDto = mockAdressDto.createRequestDTO().get(0);
//		Mockito.when(locationFromGoogle.deleteAdress(Mockito.anyLong()))

	}

	@Test
	public void deveRetornarUmEnderecoPeloFindAll()  {
		List<AdressDto> adressDtoList = adressRestController.getAdress();
		Assert.assertNotNull(adressDtoList);
		AdressDto requestDTO = adressDtoList.get(0);
		Assert.assertEquals(new Long(1L), requestDTO.getId());
		Assert.assertEquals("Amphitheatre Parkway", requestDTO.getStreetName());
		Assert.assertEquals(new Integer(1600), requestDTO.getNumber());
		Assert.assertEquals("", requestDTO.getComplement());
		Assert.assertEquals("", requestDTO.getNeighbourhood());
		Assert.assertEquals("Mountain View", requestDTO.getCity());
		Assert.assertEquals("CA", requestDTO.getState());
		Assert.assertEquals("United States", requestDTO.getCountry());
		Assert.assertEquals("74000000", requestDTO.getZipcode());
		Assert.assertEquals(new Double(37.4220656), requestDTO.getLatitude());
		Assert.assertEquals(new Double(-122.0840897), requestDTO.getLongitude());

	}

	@Test
	public void deveRetornarUmEnderecoPeloFinById()  {
		AdressDto requestDTO = adressRestController.getAdressById(1L);
		Assert.assertNotNull(requestDTO);
		Assert.assertEquals(new Long(1L), requestDTO.getId());
		Assert.assertEquals("Amphitheatre Parkway", requestDTO.getStreetName());
		Assert.assertEquals(new Integer(1600), requestDTO.getNumber());
		Assert.assertEquals("", requestDTO.getComplement());
		Assert.assertEquals("", requestDTO.getNeighbourhood());
		Assert.assertEquals("Mountain View", requestDTO.getCity());
		Assert.assertEquals("CA", requestDTO.getState());
		Assert.assertEquals("United States", requestDTO.getCountry());
		Assert.assertEquals("74000000", requestDTO.getZipcode());
		Assert.assertEquals(new Double(37.4220656), requestDTO.getLatitude());
		Assert.assertEquals(new Double(-122.0840897), requestDTO.getLongitude());
	}

	@Test
	public void deveInserirUmEndereco()  {
		AdressDto adressDto = mockAdressDto.createRequestDTO().get(0);

		AdressDto requestDTO = adressRestController.createAdress(adressDto);

		Assert.assertNotNull(requestDTO);
		Assert.assertEquals(new Long(1L), requestDTO.getId());
	}

	@Test
	public void deveInserirUmEnderecoSemLatELong()  {
		AdressDto adressDto = mockAdressDto.createRequestDTO().get(0);
		adressDto.setLongitude(null);
		adressDto.setLatitude(null);

		AdressDto requestDTO = adressRestController.createAdress(adressDto);

		Assert.assertNotNull(requestDTO);
		Assert.assertEquals(new Long(1L), requestDTO.getId());
		Assert.assertEquals(new Double(37.4220656), requestDTO.getLatitude());
		Assert.assertEquals(new Double(-122.0840897), requestDTO.getLongitude());
	}

	@Test
	public void deveAtualizarUmEnderecoSemLatELong()  {
		AdressDto adressDto = mockAdressDto.createRequestDTO().get(0);

		AdressDto requestDTO = adressRestController.createAdress(adressDto);

		Assert.assertNotNull(requestDTO);
		Assert.assertEquals(new Long(1L), requestDTO.getId());
		Assert.assertEquals(new Double(37.4220656), requestDTO.getLatitude());
		Assert.assertEquals(new Double(-122.0840897), requestDTO.getLongitude());
	}

	@Test
	public void deveExcluirUmEnderecoSemLatELong()  {

		AdressDto dto = mock(AdressDto.class);

		doAnswer((adressDto) -> {
			adressRestController.deleteAdress(adressDto.getArgument(0));
			Assert.assertEquals(null, adressDto.getArgument(0));
			return null;
		}).when(dto).setId(1L);
	}

		
}
