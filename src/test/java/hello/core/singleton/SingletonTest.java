package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    void 스프링_없는_순수한_컨테이너(){

        AppConfig appConfig = new AppConfig();

        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService = appConfig.memberService();
        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        Assertions.assertThat(memberService).isNotSameAs(memberService1);
    }

    @Test
    void 싱글톤_패턴을_사용한_객체_사용(){
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        //TODO same과 equal 차이 조사
        Assertions.assertThat(instance).isEqualTo(instance2);
    }

    @Test
    void 스프링_컨테이너와_싱글톤(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService1).isSameAs(memberService2);

    }
}
