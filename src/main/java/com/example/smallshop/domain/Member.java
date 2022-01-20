package com.example.smallshop.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberForm memberForm, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(memberForm.getName());
        member.setEmail(memberForm.getEmail());
        String password = passwordEncoder.encode(memberForm.getPassword());
        member.setPassword(password);
        member.setRole(Role.USER);
        return member;
    }

}
