package info.magat.appcxmapper;

import info.magat.appcxmapper.config.SimpleContextConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextMapperTests {

    @Test
    public void first_test() {
        new ContextMapper().map(new AnnotationConfigApplicationContext(SimpleContextConfig.class));
    }
}
