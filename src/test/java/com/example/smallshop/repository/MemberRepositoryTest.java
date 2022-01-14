package com.example.smallshop.repository;

import com.example.smallshop.domain.Member;
import com.example.smallshop.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    public void 멤버_등록(){

        Member member = new Member();
        member.setName("hyeb");
        member.setEmail("hyeb@na");
        member.setPassword("123123");
        memberRepository.save(member);

        List<Member> memberList = memberRepository.findAll();

        Member member1 = memberList.get(0);
        assertThat(member.getName()).isEqualTo(member1.getName());
    }

    @Test
    public void 멤버_불러오기(){
        List<Member> members = memberRepository.findAll();
        assertThat(4).isEqualTo(members.size());
    }

    @Test
    public void 멤버_아이디로찾기(){
        Long id = 2L;
        assertThat(id).isEqualTo(memberService.findById(id));
    }

}