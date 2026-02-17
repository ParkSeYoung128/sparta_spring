package com.sparta.springauth.controller;

import com.sparta.springauth.dto.LoginRequestDto;
import com.sparta.springauth.dto.SignupRequestDto;
import com.sparta.springauth.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
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
    public String signup(SignupRequestDto requestDto){  /* 브라우저에서의 입력값을 Dto 에 자동 바인딩 */
        userService.signup(requestDto);

        return "redirect:/api/user/login-page"; /* 브라우저에게 다시 GET 요청을 보내라고 지시(로그인 페이지로 이동) */
    }

    /**스프링 MVC 구조
     * 브라우저
     *    ↓
     * Tomcat (Servlet Container)
     *    ↓
     * DispatcherServlet (스프링 핵심)
     *    ↓
     * Controller
     * | 객체                  | 역할                 |
     * | ------------------- | ------------------ |
     * | HttpServletRequest  | 브라우저가 보낸 요청 정보     |
     * | HttpServletResponse | 서버가 브라우저에 보낼 응답 정보 |
     * Spring MVC는 메서드 파라미터를 보고
     * DTO면 자동 바인딩
     * HttpServletResponse면 서블릿 객체 주입 -> 브라우저에게 뭘 보낼지 조작하는 객체
     * HttpServletRequest면 요청 객체 주입
     */
    @PostMapping("/user/login")
    public String login(LoginRequestDto requestDto, HttpServletResponse res) {  // res는 로그인 성공 시 JWT를 쿠키로 내려준다
        try{
            userService.login(requestDto, res);
        } catch (Exception e){
            return "redirect:/api/user/login-page?error";
        }

        return "redirect:/";
    }
}