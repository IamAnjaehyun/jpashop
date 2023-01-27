package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    //Transactional 이 Test에 있으면 끝난 다음에 Roll Back
    @Rollback(value = false) //이거 있으면 rollback안함
    public void testMember() throws Exception{
        //given
//        Member member = new Member();
//        member.setUsername("memberA");
//
//        //when
//        Long savedId = memberRepository.save(member);
//        Member findMember = memberRepository.find(savedId);
//
//        //then
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId()); //T
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername()); //T
//        Assertions.assertThat(findMember).isEqualTo(member); //T
//        System.out.println("findMember == member : " + (findMember == member));

    }
}