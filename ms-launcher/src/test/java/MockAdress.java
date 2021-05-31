import br.com.tonni.data.AdressDto;
import br.com.tonni.entity.Adress;

import java.util.ArrayList;
import java.util.List;

public class MockAdress {

	/* 
	 * Retorno para o mock do Adress
	 */
	public List<Adress> createRequest() {

		List<Adress> list = new ArrayList<>();
		Adress request = new Adress();
		request.setId(1L);
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
