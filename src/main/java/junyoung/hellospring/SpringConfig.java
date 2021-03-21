package junyoung.hellospring;

import junyoung.hellospring.domain.Member;
import junyoung.hellospring.repository.MemberRespository;
import junyoung.hellospring.repository.MemoryMemberRepository;
import junyoung.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRespository());
    }

    @Bean
    public MemberRespository memberRespository(){
        return new MemoryMemberRepository();
    }
}
