package info.magat.appcxmapper;

import org.springframework.context.ApplicationContext;

public class ContextMapper {

    public void map(ApplicationContext ctx){
        //This is where the magic happens
        var beans = ctx.getBeanDefinitionNames();

        for (String bean : beans) {
            Class<?> beanClass = ctx.getBean(bean).getClass();
            Object same = ctx.getBean(bean, beanClass);

            if(bean.equals(same)){
                throw new IllegalStateException("I wasn't expecting that");
            }
        }
    }


}
