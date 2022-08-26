package com.example.beginner.controller;

import com.example.beginner.dto.MemberRequestDto;
import com.example.beginner.dto.MemberResponseDto;
import com.example.beginner.dto.TokenDto;
import com.example.beginner.dto.TokenRequestDto;
import com.example.beginner.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")        // "/auth/**" 요청은 모두 허용해서 토큰 검증 로직을 타지 않음.
@RequiredArgsConstructor
public class AuthController {

    // MemberRequestDto 에는 사용자가 로그인 시도한 ID/ PW String이 존재함.
    // TokenRequestDto에는 재발급을 위한 AccessToken / RefreshToken String이 존재함.
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {

        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}