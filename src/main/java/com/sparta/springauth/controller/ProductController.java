package com.sparta.springauth.controller;

import com.sparta.springauth.entity.User;
import com.sparta.springauth.security.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/products")
    public String getProducts(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        // Authentication의 principal -> 인증 객체 안에 있는 UserDetailsImpl, 즉 회원 정보를 가져와 아래와 같이 출력한다.

        User user = userDetails.getUser();
        System.out.println("user.getUsername() = " + user.getUsername());
        // ~.soutv -> 출력문 자동 생성
        return "redirect:/";
    }
}