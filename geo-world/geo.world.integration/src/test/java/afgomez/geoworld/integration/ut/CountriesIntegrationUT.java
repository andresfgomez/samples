package afgomez.geoworld.integration.ut;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import afgomez.geoworld.integration.CountriesIntegration;
import afgomez.geoworld.integration.model.Country;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author agomez
 */
@RunWith(MockitoJUnitRunner.class)
public class CountriesIntegrationUT extends CountriesIntegration {

    public CountriesIntegrationUT() {
        clientCountries = mock(Client.class);
    }

    @Test
    public void findAllCountriesOk() {

        WebTarget webTarget = mock(WebTarget.class);
        WebTarget webTargetPath = mock(WebTarget.class);
        Invocation.Builder builder = mock(Invocation.Builder.class);
        Response response = mock(Response.class);

        when(clientCountries.target("http://restcountries.eu")).thenReturn(webTarget);
        when(webTarget.path("rest/v1/all")).thenReturn(webTargetPath);
        when(webTargetPath.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get()).thenReturn(response);
        when(response.readEntity(List.class)).thenReturn(getContentResponse());

        List<Country> countries = findAllCountries();

        assertFalse("Must not be empty", countries.isEmpty());

    }

    public List<Map<String, Object>> getContentResponse() {
        List<Map<String, Object>> countries = new ArrayList<>(1);

        Map<String, Object> country1 = new HashMap<>();
        country1.put("name", "Colombia");
        country1.put("capital", "Bogota");

        countries.add(country1);

        return countries;
    }

}
