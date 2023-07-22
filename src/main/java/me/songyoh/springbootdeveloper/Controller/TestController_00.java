package me.songyoh.springbootdeveloper.Controller;

import me.songyoh.springbootdeveloper.Service.TestService_00;
import me.songyoh.springbootdeveloper.entity.Member_00;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController_00 {

    @Autowired
    TestService_00 testService;

    @GetMapping("/test")
    public List<Member_00> getAllMembers(){
        List<Member_00> members = testService.getAllMembers();
        return members;
    }
}
