package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    private DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    void VIP_할인_금액(){
        Member member = new Member(1L, "VIP_Member", Grade.VIP);
        int discountPrice = discountPolicy.discount(member, 10000);
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    void Basic_할인_금액(){
        Member member = new Member(2L, "BASIC_Member", Grade.BASIC);
        int discountPrice = discountPolicy.discount(member, 10000);
        Assertions.assertThat(discountPrice).isEqualTo(0);
    }

}