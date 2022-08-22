package com.example.beginner.dto;

import com.example.beginner.entity.Authority;
import com.example.beginner.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class MemberRequestDto {



    @NotBlank(message = "아이디를 입력해주세요")
    @Pattern(regexp = "^[a-z0-9]{4,32}$", message = "비밀번호를 4~32자로 입력해주세요")
    private String nickname;

    //    @Pattern(regexp = "^[a-z0-9]{4,32}$", message = "비밀번호를 4~32자로 입력해주세요")
    @Size(min = 4, message = "비밀번호는 4자 이상.")
    private String password;
    private String passwordCheck;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .nickname(nickname)
                .password(passwordEncoder.encode(password))
                .passwordCheck(passwordEncoder.encode(passwordCheck))
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(nickname, password);
    }
}