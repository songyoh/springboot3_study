package me.songyoh.springbootdeveloper.Controller;

import lombok.RequiredArgsConstructor;
import me.songyoh.springbootdeveloper.DTO.ArticleResponse;
import me.songyoh.springbootdeveloper.Request.AddArticleRequest;
import me.songyoh.springbootdeveloper.Request.UpdateArticleRequest;
import me.songyoh.springbootdeveloper.Service.BlogService;
import me.songyoh.springbootdeveloper.entity.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiContorller {

    private final BlogService blogService;

    // HTTP 메서드가 POST일때 전달받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request, Principal principal) {
        Article savedArticle = blogService.save(request, principal.getName());

        // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    // 전체 글을 조회한뒤 반환하는 findAllArticles() 메서드 추가
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }
    // api/articles GET 요청시 글 전체를 조회하는 findAll()메서드 호출한 뒤 응답용 객체인 ArticleResponse로 파싱해 body에 담아 클라이언트에게 전송한다.

    // /api/articles/{id} GET 요청이 오면 블로그 글을 조회하기 위해 매핑할 findArticle() 메서드 작성
    @GetMapping("/api/articles/{id}") // URL 경로에서 값 추출
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    // /api/articles/{id} DELETE 요청이 오면 글을 삭제하기 위한 findArticles()메서드 작성
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
                                                 @RequestBody UpdateArticleRequest request){
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }

}
