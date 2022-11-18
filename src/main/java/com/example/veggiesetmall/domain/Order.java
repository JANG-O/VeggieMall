package com.example.veggiesetmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

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
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id") // fk 이름
    private Member member;
    // 주문 상품
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    // 배송
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    // 주문 시간
    private LocalDateTime orderDate;
    // 주문 상태 (order, cancel)
    @Enumerated(EnumType.STRING)  // Value가 String로 들어감
    private OrderStatus status;

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
