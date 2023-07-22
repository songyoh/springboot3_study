package me.songyoh.springbootdeveloper.Repository;

import me.songyoh.springbootdeveloper.entity.Member_00;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository_00 extends JpaRepository<Member_00, Long> {
}
