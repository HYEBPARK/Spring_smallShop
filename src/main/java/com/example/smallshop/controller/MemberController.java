package com.example.smallshop.controller;

import com.example.smallshop.domain.Item;
import com.example.smallshop.domain.ItemForm;
import com.example.smallshop.domain.Member;
import com.example.smallshop.domain.MemberForm;
import com.example.smallshop.service.ItemService;
import com.example.smallshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public String createMember(Model model){
        model.addAttribute("memberFrom", new MemberForm());
        return "member/createMemberForm";
    }

    @PostMapping("/member")
    public String create(MemberForm memberForm){
        Member member = Member.createMember(memberForm);
        memberService.saveMember(member);
        return "redirect:/";
    }

    @GetMapping("/member/list")
    public String list(Model model){
        List<Member> members = memberService.findAll();
        model.addAttribute("members",members);
        return "member/MemberList";
    }
}

// 회원 등록, 회원 목록
// member db
// member_id, member_name member_email member_password member_role

// 상품 등록, 상품 목록
// item db
// item_id, item_name, item_price

// order item 주문 된 상품 ?
// orderItem
// member_id, item_id

// 상품 주문 , 주문 내역
// order dv
// order_id item_id item_quantity item_totalPrice