package com.example.smallshop.service;

import com.example.smallshop.domain.Member;
import com.example.smallshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    private void validDuplicateMember(Member member){
        String MemberEmail = member.getEmail();
        Member findMember = memberRepository.findByEmail(MemberEmail);
        if(findMember != null) throw new IllegalStateException("이미 가입된 회원입니다.");
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

}
