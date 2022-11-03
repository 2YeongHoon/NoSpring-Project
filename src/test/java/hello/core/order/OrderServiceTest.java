package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private MemberService memberService = new MemberServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    @Test
    void 등급에따른_할인_금액을_확인(){
        Long memberId = 1L;
        Member member = new Member(memberId, "이영훈", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "자전거", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
