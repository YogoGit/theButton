package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// spring config file, finds these annotations and uses the beans that are defined.
@Configuration
@ComponentScan(
    value = {
        "controllers",
        "services",
    }
)
public class AppConfig {

}