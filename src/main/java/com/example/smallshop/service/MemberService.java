package com.example.smallshop.service;

import com.example.smallshop.domain.Member;
import com.example.smallshop.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save(Member member){
        memberRepository.save(member);
    }
    
    public Long findById(Long id){
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalAccessError("멤버 없음"));
        return member.getId();
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

}
