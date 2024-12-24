package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // spring boot랑 연동한 통합 테스트 수행
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // 예상 결과 값 - 예상하는 값들을 변수에 넣어서 리스트화
        Article a = new Article(1L, "가가가가가", "1111");
        Article b = new Article(2L, "나나나나나", "2222");
        Article c = new Article(3L, "다다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));

        // 실제 결과 값
        List<Article> articles = articleService.index();

        // 비교 (예상 값, 실제 값)
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    @Transactional
    void show_성공__존재하는_id_입력() {
        // 예상
        Long id = 1L;
        Article expected = new Article(id, "가가가가가", "1111");

        // 실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void show_실패__존재하지않는_id_입력() {
        // 예상 - 존재하지 않는 값 넣기
        Long id = -1L;
        Article expected = null;
        // 만든 서비스에서 예외 처리를 null로 했기에 예상도 null로 함

        // 실제
        Article article = articleService.show(id);

        // 비교 - 예상 값이 null 이기에 toString 사용 안 됨
        assertEquals(expected, article);
    }

    @Test
    void create_성공__title과_content만_있는_dto_입력() {
        // 예상
        String title = "랄랄라라";
        String content = "aaaa";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_실패__id가_호환된_dto_입력() {
        // id가 호환된 dto 입력 시 create가 아닌 update가 되는 점을 예외 처리한 것에 대핱 테스트
        // 예상
        String title = "랄랄라라";
        String content = "aaaa";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null; // 예외 처리를 null로 했으므로

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected, article);

    }

    @Test
    void update_성공__존재하는_id와_title_content가_있는_dto_입력() {
        // 예상
        Long id = 1L;
        String title = "가가가가가";
        String content = "1111";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());

    }

    @Test
    void update_성공__존재하는_id와_title만_있는_dto_입력() {
        // 예상
        Long id = 1L;
        String title = "가가가가가";
        String content = "1111";
        ArticleForm dto = new ArticleForm(id, title, null); // 보낼값
        Article expected = new Article(id, title, content); // 예상값

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_실패__존재하지않는_id의_dto_입력() {
        // 예상
        Long id = -1L;
        String title = "가가가가가";
        String content = "1111";
        ArticleForm dto = new ArticleForm(id, title, null);
        Article expected = null;

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void delete_성공__존재하는_id_입력() {
        // 예상
        Long id = 1L;
        Article expected = new Article(id, "가가가가가", "1111");

        // 실제
        Article article = articleService.delete(id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void delete_실패__존재하지않는_id_입력() {
        // 예상
        Long id = -1L;
        Article expected = null;

        // 실제
        Article article = articleService.delete(id);

        // 비교
        assertEquals(expected, article);
    }
}