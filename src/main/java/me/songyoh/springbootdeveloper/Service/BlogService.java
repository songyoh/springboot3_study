package me.songyoh.springbootdeveloper.Service;

import lombok.RequiredArgsConstructor;
import me.songyoh.springbootdeveloper.Repository.BlogRepository;
import me.songyoh.springbootdeveloper.Request.AddArticleRequest;
import me.songyoh.springbootdeveloper.Request.UpdateArticleRequest;
import me.songyoh.springbootdeveloper.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @Notnull이 붙은 필드의 생성자 추가
@Service // 빈 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    // DB에 저장되어있는 글을 모두 가져오는 findAll()메서드 추가
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    // 블로그 글 하나 조회 findById() - 단일조회
    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id));
    } // findById() 메서드를 사용해 ID를 받아 엔터티를 조회하고 없으면 IllegalArgumentException 예외 발생

    // 블로그 글의 ID를 받은 뒤 JPA에서 제공하는 deleteById() 메서드를 이용해 DB에서 삭제
    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found" + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
