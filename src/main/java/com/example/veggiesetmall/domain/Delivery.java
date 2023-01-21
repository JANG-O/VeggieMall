package com.example.veggiesetmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Delivery {

    // 기본키
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    // 주문
    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;
    // 주문자 주소
    @Embedded
    private Address address;
    // 배달 상태
    @Enumerated(EnumType.STRING)  // Value가 String로 들어감
    private DeliveryStatus status;

}
