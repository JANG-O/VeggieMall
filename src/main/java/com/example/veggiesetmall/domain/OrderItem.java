package com.example.veggiesetmall.domain;

import com.example.veggiesetmall.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class OrderItem {

    // 기본키
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    // 상품
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    // 주문
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    // 주문 가격
    private int orderPrice;
    // 주문 상품 수량
    private int count;
}
