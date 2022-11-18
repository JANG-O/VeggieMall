package com.example.veggiesetmall.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("B")   // 상속관계 매핑
@Getter
@Setter
public class Book extends Item{

    // 저자
    private String author;
    // 도서번호
    private String isbn;

}
