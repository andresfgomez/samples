package afgomez.geoworld.integration;

import afgomez.geoworld.integration.model.Country;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Service;

/**
 *
 * @author agomez
 */
@Service
public class CountriesIntegration {

    protected Client clientCountries = null;

    public CountriesIntegration() {
        clientCountries = ClientBuilder.newBuilder().build();
    }

    public List<Country> findAllCountries() {

        Response response = clientCountries.target("http://restcountries.eu").path("rest/v1/all").request(MediaType.APPLICATION_JSON).get();

        List<Map<String, Object>> message = response.readEntity(List.class);
        if (message == null) {
            return null;
        }

        return message.stream().parallel().map(m -> convert(m)).collect(Collectors.toList());
    }

    private Country convert(Map<String, Object> record) {
        Country country = new Country();
        country.setName((String) record.get("name"));
        country.setCapital((String) record.get("capital"));

        return country;
    }

}
