package com.example.veggiesetmall.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("M")   // 상속관계 매핑
@Getter
@Setter
public class Movie extends Item {

    // 감독
    private String director;
    // 배우
    private String actor;

}
