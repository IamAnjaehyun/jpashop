package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
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
@Transactional //rollback위함 . 데이터 올리니까 롤백 해야함
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
//    @Autowired EntityManager em; //이거랑 em.flush 하면 인서트문 볼 수 있음


    @Test
//    @Rollback(value = false)//이거 하면 insert문 보임 (Transactional 안걸림)
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("an");

        //when
        Long savedId = memberService.join(member);

        //then
//        em.flush(); //db에 쿼리가 나감
        assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("an");

        Member member2 = new Member();
        member2.setName("an");

        //when
        memberService.join(member1);
        memberService.join(member2); //예외가 발생해야 한다!! 같은 an이 두명이니까

        //위에 excepted = IllegalStateException.class 이거 있으면 try catch 안해도됨
//        try {
//            memberService.join(member2); //예외가 발생해야 한다!! 같은 an이 두명이니까
//        }catch (IllegalStateException e){
//            return;
//        }

        //then
        fail("예외가 발생해야 한다."); //fail 뜨면 뜸

    }

}