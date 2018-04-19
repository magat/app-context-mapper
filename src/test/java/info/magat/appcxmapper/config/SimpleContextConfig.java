package info.magat.appcxmapper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleContextConfig {

    @Bean
    public Service myService(){
        return new Service(repo());
    }

    @Bean
    public Repo repo(){
        return new Repo();
    }
}
