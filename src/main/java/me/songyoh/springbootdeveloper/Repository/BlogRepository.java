package me.songyoh.springbootdeveloper.Repository;

import me.songyoh.springbootdeveloper.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
} // JpaRepository 클래스를 상속받을 때 엔터티 Article과 엔터티의 PK타입 Long을 인수로 넣는다.
    // 그렇게 할 경우 이 레포지토리를 사용시 JpaRepository에서 제공하는 여러 메서드를 사용할 수 있다.
