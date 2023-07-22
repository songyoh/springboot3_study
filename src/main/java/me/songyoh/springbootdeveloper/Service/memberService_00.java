package me.songyoh.springbootdeveloper.Service;

import me.songyoh.springbootdeveloper.Repository.MemberRepository_00;
import me.songyoh.springbootdeveloper.entity.Member_00;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class memberService_00 {

    @Autowired
    MemberRepository_00 memberRepository;

    public void test(){
        // 생성
        memberRepository.save(new Member_00(1L, "A"));

        //조회
        Optional<Member_00> member = memberRepository.findById(1L); //단건 조회
        List<Member_00> allMembers = memberRepository.findAll(); //전체 조회

        //삭제
        memberRepository.deleteById(1L);

    }
}
