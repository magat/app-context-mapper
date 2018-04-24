package info.magat.appcxmapper.test.config;

import info.magat.appcxmapper.test.data.Repo;
import info.magat.appcxmapper.test.data.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleContextConfig {

    @Bean
    public Service myService(){
        return new Service(repo(), null, null);
    }

    @Bean
    public Repo repo(){
        return new Repo("SimpleRepo");
    }
}
