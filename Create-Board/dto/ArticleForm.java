package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 모든 필드를 생성자로 만들겠다는 의미
@ToString //toString 메소드 가져온 거
public class ArticleForm {

    private Long id;
    private String title;
    private String content;


    public Article toEntity() { // dto 값을 entity로 변환해주는 메소드
        return new Article(id, title, content);
    }
}
