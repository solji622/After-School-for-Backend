package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity // DB가 해당 객체 인식 가능
@AllArgsConstructor
@ToString
public class Article {
    @Id // 대표값을 지정! 학번 같이!
    @GeneratedValue // 1, 2, 3,.. 자동 생성 어노테이션 (우왕)
    private Long id;

    @Column
    private String title;
    @Column
    private String content;

}
