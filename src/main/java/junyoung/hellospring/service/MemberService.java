package junyoung.hellospring.service;

import junyoung.hellospring.domain.Member;
import junyoung.hellospring.repository.MemberRespository;
import junyoung.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRespository memberRespository;

    public MemberService(MemberRespository memberRespository){
        this.memberRespository = memberRespository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원X
        validateDuplicatedMember(member);
        memberRespository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        Optional<Member> result = memberRespository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }


    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRespository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRespository.findById(memberId);
    }

}
