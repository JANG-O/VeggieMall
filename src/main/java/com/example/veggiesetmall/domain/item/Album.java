package com.example.veggiesetmall.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")  // 상속관계 매핑
@Getter
@Setter
public class Album extends Item {

    // 가수
    private String artist;
    // 기타
    private String etc;
}