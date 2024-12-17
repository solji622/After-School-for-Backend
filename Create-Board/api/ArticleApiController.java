package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {

    @Autowired // 스프링부트가 갖고 있는 것을 사용하겠다 (DI 의존주입)
    private final ArticleRepository articleRepository;

    public ArticleApiController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleRepository.findAll();
    }

    @GetMapping("/api/articles/{id}")
    public Article index(@PathVariable long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto) {
        // @RequestBody - body 데이터를 넣어서 전송해줌
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }

    // PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable long id, @RequestBody ArticleForm dto) {
        // 1. 수정용 엔티티 생성
        Article article = dto.toEntity();

        // 2. 대상 엔티티 조회
        Article target = articleRepository.findById(id).orElse(null);

        // 3. 잘못된 요청 처리 (대상이 없거나, id가 다른 경우)
        if (target == null || id != article.getId()) {
            // 400, 잘못된 요청 응답
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            // ResponseEntity는 리턴타입이 같아야되기에 메서드 타입도  ResponseEntity<Article>
        }

        // 4. 업데이트 및 정상 응답 (200)
        target.patch(article); // 기존 데이터와 합치는 메서드
        Article updated = articleRepository.save(target); // 정리된 데이터 저장

        return ResponseEntity.status(HttpStatus.OK).body(updated);
        // 성공했다는 메세지와 함께 데이터 전송
    }

    // DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable long id) {
        // 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);

        // 잘못된 요청 처리
        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // 대상 삭제
        articleRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
        // build == body(null)
    }
}
