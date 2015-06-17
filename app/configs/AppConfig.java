package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//designates packages that spring is interested in.  Annotations in said classes allow it to be injected into or injected.
@Configuration
@ComponentScan(
    value = {
        "controllers",
        "services",
    })
public class AppConfig {

}
