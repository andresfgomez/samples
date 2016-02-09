package afgomez.geoworld.integration;

import afgomez.geoworld.integration.model.Country;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author agomez
 */
public class CountriesIntegration {

    public List<Country> findAllCountries() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://restcountries.eu").path("rest/v1/all").request(MediaType.APPLICATION_JSON).header("Content-Type", "application/json;charset=utf-8").get();

        List<Map<String, Object>> message = response.readEntity(ArrayList.class);

        if (message == null) {
            return null;
        }

        List<Country> countries = message.stream().parallel().map(m -> convert(m)).collect(Collectors.toList());

        return countries;
    }

    private Country convert(Map<String, Object> record) {
        Country country = new Country();
        country.setName((String) record.get("name"));
        country.setCapital((String) record.get("capital"));

        return country;
    }

}
