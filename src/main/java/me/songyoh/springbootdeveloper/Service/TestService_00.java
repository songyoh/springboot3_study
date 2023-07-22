package me.songyoh.springbootdeveloper.Service;

import me.songyoh.springbootdeveloper.Repository.MemberRepository_00;
import me.songyoh.springbootdeveloper.entity.Member_00;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService_00 {

    @Autowired
    MemberRepository_00 memberRepository;

    public List<Member_00> getAllMembers(){
        return memberRepository.findAll();
    }
}
