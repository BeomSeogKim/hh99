package com.tommy.pracforsecurity.controller.dto;

import com.tommy.pracforsecurity.member.Authority;
import com.tommy.pracforsecurity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;


@Getter
@AllArgsConstructor
@NoArgsConstructor

public class MemberRequestDto {



    @NotBlank(message = "아이디를 입력해주세요")
    @Pattern(regexp = "^[a-z0-9]{4,32}$", message = "비밀번호를 4~32자로 입력해주세요")
    private String email;

//    @Pattern(regexp = "^[a-z0-9]{4,32}$", message = "비밀번호를 4~32자로 입력해주세요")
    private String password;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}