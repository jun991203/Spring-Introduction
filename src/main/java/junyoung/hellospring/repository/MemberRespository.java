package junyoung.hellospring.repository;

import junyoung.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRespository {
    Member save(Member member);
    // Optional은 findById, findByName의 결과가 Null일 때 처리해주기 위함
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
