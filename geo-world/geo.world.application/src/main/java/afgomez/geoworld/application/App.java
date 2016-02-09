package afgomez.geoworld.application;

import afgomez.geoworld.application.spring.Config;
import afgomez.geoworld.service.CountriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author agomez
 */
public class App {
    
    static final Logger LOG = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args) {
        
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
            CountriesService service = context.getBean(CountriesService.class);
            service.findAllCountries().stream().forEach(c -> LOG.info(c.toString()));
        }
        
    }
    
}
