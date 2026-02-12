package com.sparta.springauth.controller;

import com.sparta.springauth.dto.SignupRequestDto;
import com.sparta.springauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor    // final 필드의 생성자를 자동 생성
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("user/signup")
    public String signup(SignupRequestDto requestDto){  /** 브라우저에서의 입력값을 Dto 에 자동 바인딩 */
        userService.signup(requestDto);

        return "redirect:/api/user/login-page"; /** 브라우저에게 다시 GET 요청을 보내라고 지시(로그인 페이지로 이동) */
    }
}