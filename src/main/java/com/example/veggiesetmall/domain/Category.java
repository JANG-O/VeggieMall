package com.example.veggiesetmall.domain;

import com.example.veggiesetmall.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    // 기본키
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    // 카테고리명
    private String name;
    // 아이템
    @ManyToMany
    @JoinTable(name = "category_item",
        joinColumns = @JoinColumn(name = "category_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();
    // 부모
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;
    // 자식
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
}
