package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// TEST APP
public class MemberApp {

    public static void main(String[] args){
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class );

        Member member1 = new Member(1L, "Lee", Grade.VIP);
        memberService.join(member1);

        Member member2 = memberService.findMember(1L);

        System.out.println("member1: " + member1.getName());
        System.out.println("member2: " + member2.getName());
    }
}
