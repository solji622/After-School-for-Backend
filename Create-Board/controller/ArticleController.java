package com.example.firstproject.controller;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j // 심플하게 로그찍기
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해놓은 객체를 가져다가 자동으로 연결
    private ArticleRepository articleRepository;
    // di 의존주의 : 스프링이 만들어준 객체에 연결만 해주는 것
    @Autowired
    private CommentService commentService;

    @GetMapping("/article/new")
    public String newArticleForm() {
        return "article/new";
    }

    @PostMapping("/article/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());
//        System.out.println(form.toString());

        // 1. dto 객체 변환 -> Entity
        Article article = form.toEntity();
        log.info(article.toString());
//        System.out.println(article.toString());

        // 2. repository에게 Entity를 DB안에 저장하도록 명령
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
//        System.out.println(saved.toString());

        return "redirect:/article/" + saved.getId();
    }

    @GetMapping("/article/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        // 1. id로 데이터를 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentDtos = commentService.comments(id);

        // 2. 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);
        model.addAttribute("commentDtos", commentDtos);

        // 3. 보여줄 페이지를 설정!
        return "article/show";

    }

    @GetMapping("/article")
    public String index(Model model) {
        // 1. 모든 Article 가져오기
        List<Article> articleEntityList = articleRepository.findAll();
        // 원래는 다운캐스팅 해야함 > 레포에서 findALl을 ArrayList형으로 메서드 오버라이딩 해서 생략 가능
        // Iterable<Article> articleEntityList = articleEntityList;

        // 2. 가져온 Article 묶음을 View로 전달
        model.addAttribute("articleList", articleEntityList);

        // 3. View 페이지 생성
        return "article/index";
    }

    @GetMapping("/article/{id}/edit")
    // 어노테이션에서 변수 작성 시 중괄호 한개만
    // 세개의 id가 모두 같은 것을 가리켜야 한다!
    public String edit(@PathVariable Long id, Model model) {
        // 수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 모델에 데이터 등록
        model.addAttribute("article", articleEntity);

        // view page 설정
        return "article/edit";
    }

    @PostMapping("article/update")
    public String update(ArticleForm form) {
        log.info(form.toString());
        // 1. DTO를 엔티티로 변환
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());


        // 2. 엔티티를 DB로 저장!
        // 2-1. DB에서 기존 데이터 가져오기
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        // 2-2. 기존 데이터가 존재하면 값을 갱신
        if(target != null) {
            articleRepository.save(articleEntity);
        }


        // 3. 수정 결과 페이지로 리다이렉트
        return "redirect:/article/" + articleEntity.getId();
    }


    // deletemapping도 있지만 form을 데이터로 받아오기에 GET과 POST 로만 받아올 예정
    @GetMapping("/article/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("삭제 요청이 들어왔습니다!");
        // 1. 삭제 대상을 가져오기
        Article target = articleRepository.findById(id).orElse(null);

        // 2. 대상 삭제
        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
            // flash - 잠깐 쓰고 사라지겠다는 의미
        }

        // 3. 결과 데이터로 리다이렉트
        return "redirect:/article";
    }
}