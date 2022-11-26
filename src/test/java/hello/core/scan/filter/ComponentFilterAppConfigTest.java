package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("BeanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();
    }

    @Configuration
    @ComponentScan(
        includeFilters = @ComponentScan.Filter(classes = MyIncludeComponent.class),
        excludeFilters = @ComponentScan.Filter(classes = MyExcludeComponent.class)
    )

    static class ComponentFilterAppConfig{
    }



}
