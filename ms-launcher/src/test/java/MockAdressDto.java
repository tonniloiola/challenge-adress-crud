import br.com.tonni.data.AdressDto;

import java.util.ArrayList;
import java.util.List;

public class MockAdressDto {

	/* 
	 * Retorno para o mock do AdressDto
	 */
	public List<AdressDto> createRequestDTO() {

		List<AdressDto> list = new ArrayList<>();
		AdressDto request = new AdressDto();
		request.setId(157493L);
		request.setStreetName("Amphitheatre Parkway");
		request.setNumber(1600);
		request.setComplement("");
		request.setNeighbourhood("");
		request.setCity("Mountain View");
		request.setState("CA");
		request.setCountry("United States");
		request.setZipcode("74000000");
		request.setLatitude(37.4220656);
		request.setLongitude(-122.0840897);
		list.add(request);
		return list;
	}

}
