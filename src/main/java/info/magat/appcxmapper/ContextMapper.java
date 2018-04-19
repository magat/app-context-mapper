package info.magat.appcxmapper;

import org.springframework.context.ApplicationContext;
import org.springframework.util.ReflectionUtils;

import java.util.Map;
import java.util.Optional;

public class ContextMapper {

    public void map(ApplicationContext ctx) {
        // first algo prototype
        // list all defined beans
        var beans = ctx.getBeanDefinitionNames();

        for (String beanName : beans) {

            if (beanName.startsWith("org.spring")) {
                continue;
            }

            // for each bean, lookup its class attributes
            Object bean = ctx.getBean(beanName);
            Class<?> beanClass = bean.getClass();

            ReflectionUtils.doWithFields(beanClass, f -> {
                // for every attribute
                Class<?> fieldClass = f.getType();

                // list the beans for this class in the context
                Map<String, ?> candidates = ctx.getBeansOfType(fieldClass);

                // and find out if there are any that are equal (as in reference equality) to the attribute

                f.setAccessible(true);
                Object value = ReflectionUtils.getField(f, bean);
                Optional<?> foundInContext = candidates.values().stream().filter(c -> c.equals(value)).findFirst();

                // when there is, it means we have detected a dependency between 2 beans
                if (foundInContext.isPresent()) {
                    System.out.println("Found dependency between " + beanName + " and a bean with class " + fieldClass);
                    // flag it in a map ??
                }
            });


        }
    }


}
