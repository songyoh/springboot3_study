package me.songyoh.springbootdeveloper.DTO;

import lombok.Getter;
import me.songyoh.springbootdeveloper.entity.Article;

@Getter
public class ArticleResponse {

    private final String title;
    private final String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
    // 글은 제목과 내용 구성이므로 해당 필드를 가지는 클래스를 만든뒤, 엔터테를 인수로 받는 생성자 추가
}
