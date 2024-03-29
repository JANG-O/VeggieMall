package com.example.veggiesetmall.service;

import com.example.veggiesetmall.domain.Member;
import com.example.veggiesetmall.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

//  @Autowired
    private final MemberRepository memberRepository;

/*/  @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
*/

    // 회원 가입
    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    // 회원 조회
//  @Transactional(readOnly = true)
    public List<Member> findMembers() { return memberRepository.findAll(); }
    // 회원 단건 조회
//  @Transactional(readOnly = true)
    public Member findOne(Long memberId) { return memberRepository.findOne(memberId); }

    private void validateDuplicateMember(Member member) {  // member name 속성 unique로 하는 것 추천
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
