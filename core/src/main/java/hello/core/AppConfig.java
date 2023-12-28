package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 설정 정보
@Configuration
public class AppConfig {

    // Spring Container에 등록해준다.
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository()); // 생성자 주입
    }

    @Bean
    public static MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    @Bean
    public static DiscountPolicy getDiscountPolicy() {
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }

}
