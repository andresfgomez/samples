package afgomez.geoworld.service;

import afgomez.geoworld.integration.CountriesIntegration;
import afgomez.geoworld.model.Country;
import afgomez.geoworld.model.CountryBuilder;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agomez
 */
@Service
public class CountriesService {

    private static final Logger LOG = LoggerFactory.getLogger(CountriesService.class);

    @Autowired
    private CountriesIntegration integration;

    public List<Country> findAllCountries() {

        return integration.findAllCountries().stream().parallel().map(c -> {
            LOG.debug("Country: {} ", c.toString());
            return CountryBuilder.builder().withName(c.getName()).build();
        }).collect(Collectors.toList());

    }

    public CountriesIntegration getIntegration() {
        return integration;
    }

    public void setIntegration(CountriesIntegration integration) {
        this.integration = integration;
    }

}
