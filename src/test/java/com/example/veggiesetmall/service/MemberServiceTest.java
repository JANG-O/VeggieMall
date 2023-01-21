package com.example.veggiesetmall.service;

import com.example.veggiesetmall.domain.Member;
import com.example.veggiesetmall.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {  // Junit5 테스트

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
//  @Rollback(false)  // rollback 없이 commit
//  @Rollback  // display 하지 않고 곧바로 insert
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long savedId = memberService.join(member);

        // then
//      em.flush();  // rollback하는 거 보여줌
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // when
        memberService.join(member1);
        memberService.join(member2);

        /*
        try {
            memberService.join(member2);  //예외가 발생해야 한다.
        } catch (IllegalStateException e) {
            return;
        }
        */

        // then
        fail("예외가 발생해야 한다.");  // Assert.fail
    }





}