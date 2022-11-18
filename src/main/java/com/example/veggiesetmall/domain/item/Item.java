package com.example.veggiesetmall.domain.item;

import com.example.veggiesetmall.domain.Category;
import com.example.veggiesetmall.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  // 상속 관계 전략
@DiscriminatorColumn(name = "dtype")  // 상속관계 매핑
@Getter
@Setter
public abstract class Item {

    // 기본키
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    // 상품명
    private String name;
    // 상품 가격
    private int price;
    // 상품 재고 수량
    private int stockQuantity;
    //
    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();


    //==비즈니스 로직==//

    // 재고 증가
    public void addStock(int quantity) { this.stockQuantity += quantity; }
    // 재고 감소
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity += quantity; }

}
