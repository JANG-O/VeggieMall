package com.example.veggiesetmall.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

    // 기본키 id
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name; // 사용자 이름

    @Embedded
    private Address address;  // 사용자 주소

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>(); // 양방향 관계 : Order




}
