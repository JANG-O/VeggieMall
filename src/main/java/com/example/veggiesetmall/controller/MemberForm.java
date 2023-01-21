package com.example.veggiesetmall.controller;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;


// import javax.validation.constraints.NotEmpty; --> column(nullable = false)로 수정

@Getter @Setter
public class MemberForm {

    @Column(nullable = false)
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
