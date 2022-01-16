package com.example.smallshop.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class MemberForm {
    private String name;
    private String email;
    private String password;
}
