package junyoung.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // 도메인으로 들어왔을 때, localhost:8080/
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
