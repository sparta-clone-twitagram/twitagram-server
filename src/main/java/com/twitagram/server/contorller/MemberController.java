package com.twitagram.server.contorller;


import com.twitagram.server.dto.request.LoginRequestDto;
import com.twitagram.server.dto.request.MemberRequestDto;
import com.twitagram.server.dto.response.ResponseDto;
import com.twitagram.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;


@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    //회원가입
    @RequestMapping(value = "/api/signup", method = RequestMethod.POST)
    public ResponseDto<?> signup(@RequestBody @Valid MemberRequestDto requestDto) throws MessagingException {
        return memberService.createMember(requestDto);
    }

    @RequestMapping(value = "/api/email", method = RequestMethod.GET)
    public ResponseDto<?> emailCheck(@RequestParam("username") String username,HttpServletResponse response) throws IOException {
//        response.sendRedirect("http://localhost:8080/");
        response.sendRedirect("https://sparta-omj.shop/");
        return memberService.EmailCheck(username);
    }

    //로그인
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseDto<?> login(@RequestBody @Valid LoginRequestDto requestDto, HttpServletResponse response) {
        return memberService.login(requestDto, response);
    }

    //로그아웃
    @RequestMapping(value = "/api/logout", method = RequestMethod.GET)
    public ResponseDto<?> logout(HttpServletRequest request) {
        return memberService.logout(request);
    }


}
