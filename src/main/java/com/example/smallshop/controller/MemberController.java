package com.example.smallshop.controller;

import com.example.smallshop.domain.Member;
import com.example.smallshop.repository.MemberRepository;
import com.example.smallshop.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/join")
    public String createMember(){
        return "/member/createMemberForm";
    }

    @PostMapping("/join")
    public String create( MemberForm memberForm){

        Member member = new Member();
        member.setName(memberForm.getName());
        member.setEmail(memberForm.getEmail());
        member.setPassword(memberForm.getPassword());

        memberService.save(member);

        return "redirect:/";
    }

    @GetMapping("/member/list")
    public String list(Model model){
        List<Member> members = memberService.findAll();
        model.addAttribute("members",members);
        return "member/MemberList";
    }

}
