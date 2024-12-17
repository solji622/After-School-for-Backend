package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // DB가 해당 객체 인식 가능
@AllArgsConstructor
@NoArgsConstructor // 아규먼트 없는 생성자를 만들겠따!
@ToString
@Getter // 모든 것들의 getter 생성
public class Article {
    @Id // 대표값을 지정! 학번 같이!
    //@GeneratedValue // 1, 2, 3,.. 자동 생성 어노테이션 (우왕)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id를 자동 생성하는 어노테이션
    private Long id;

    @Column
    private String title;
    @Column
    private String content;


    public void patch(Article article) {
        if (article.title != null) {
            this.title = article.title;
        }

        if (article.content != null) {
            this.content = article.content;
        }
    }
}
