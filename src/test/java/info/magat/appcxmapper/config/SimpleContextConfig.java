package info.magat.appcxmapper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class SimpleContextConfig {

    @Bean
    public Object firstBean(){
        return new HashMap<String, Integer>();
    }
}
