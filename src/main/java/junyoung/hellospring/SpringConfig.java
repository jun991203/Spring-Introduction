package junyoung.hellospring;

import junyoung.hellospring.aop.TimeTraceAop;
import junyoung.hellospring.domain.Member;
import junyoung.hellospring.repository.*;
import junyoung.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    // 스프링 부트가 설정파일(application.properties)을 보고 자체적으로 data source(빈)를 만들어 줌
    // 생성자를 통해서 주입해줌(D.I)
//   private DataSource dataSource;

//    private EntityManager em;

    private final MemberRespository memberRespository;


    @Autowired
    public SpringConfig(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRespository);
    }


//    @Bean
//    public MemberRespository memberRespository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
