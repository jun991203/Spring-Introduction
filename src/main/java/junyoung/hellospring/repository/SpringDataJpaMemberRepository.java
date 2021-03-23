package junyoung.hellospring.repository;

import junyoung.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRespository {

    @Override
    Optional<Member> findByName(String name);
}
