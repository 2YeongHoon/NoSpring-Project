package hello.core.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    public void prototypeBeanTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1: " + prototypeBean1);
        System.out.println("prototypeBean2: " + prototypeBean2);

        Assertions.assertThat(prototypeBean1).isNotEqualTo(prototypeBean2);

        // prototype으로 설정 시 스프링컨테이너는 빈 생성, 의존관계 주입, 초기화까지만 담당.
        // 따라서 스프링 컨테이너가 종료되더라도 @PreDestory는 실행되지 않음.
        // 빈 종료 콜백 사용을 위해서는 별도 종료처리 해줘야함.
        prototypeBean1.close();
        prototypeBean1.close();
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean{

        @PostConstruct
        public void init(){
            System.out.println("Bean init");
        }

        @PreDestroy
        public void close(){
            System.out.println("Bean close");
        }
    }

}
