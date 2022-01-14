package com.example.smallshop.repository;

import com.example.smallshop.domain.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

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
        System.out.println(member1.getEmail());
        System.out.println(member.getEmail());
    }
}