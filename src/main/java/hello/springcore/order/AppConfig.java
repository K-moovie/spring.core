package hello.springcore.order;

import hello.springcore.discount.DiscountPolicy;
import hello.springcore.discount.FixDiscountPolicy;
import hello.springcore.discount.RateDiscountPolicy;
import hello.springcore.member.MemberRepository;
import hello.springcore.member.MemberService;
import hello.springcore.member.MemberServiceImpl;
import hello.springcore.member.MemoryMemberRepository;

// 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
// 생성한 객체의 인스턴스를 생성자를 통해서 주입해준다.

public class AppConfig {

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    // 생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
