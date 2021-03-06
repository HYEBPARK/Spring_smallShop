package com.example.smallshop.controller;

import com.example.smallshop.domain.Item;
import com.example.smallshop.domain.ItemForm;
import com.example.smallshop.domain.Member;
import com.example.smallshop.domain.MemberForm;
import com.example.smallshop.service.ItemService;
import com.example.smallshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/member")
    public String createMember(Model model){
        model.addAttribute("memberFrom", new MemberForm());
        return "member/createMemberForm";
    }

//    @PostMapping("/member")
//    public String create(MemberForm memberForm){
//       Member member = Member.createMember(memberForm, passwordEncoder);
//       memberService.saveMember(member);
//       return "redirect:/";
//    }

    @PostMapping(value = "/member")
    public String reMember(@Valid MemberForm memberForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) return "member/createMemberForm";
        try {
            Member member = Member.createMember(memberForm,passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "member/createMemberForm";
        }

        return "redirect:/";
    }

    @GetMapping("/member/list")
    public String list(Model model){
        List<Member> members = memberService.findAll();
        model.addAttribute("members",members);
        return "member/MemberList";
    }
}

// ?????? ??????, ?????? ??????
// member db
// member_id, member_name member_email member_password member_role

// ?????? ??????, ?????? ??????
// item db
// item_id, item_name, item_price

// order item ?????? ??? ?????? ?
// orderItem
// member_id, item_id

// ?????? ?????? , ?????? ??????
// order dv
// order_id item_id item_quantity item_totalPrice