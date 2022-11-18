package com.example.veggiesetmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    // 기본키
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    // 양방향 관계 : Member
    @ManyToOne
    @JoinColumn(name = "member_id") // fk 이름
    private Member member;
    // 주문 상품
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();
    // 배송
    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    // 주문 시간
    private LocalDateTime orderDate;
    // 주문 상태 (order, cancel)
    @Enumerated(EnumType.STRING)  // Value가 String로 들어감
    private OrderStatus status;
}
