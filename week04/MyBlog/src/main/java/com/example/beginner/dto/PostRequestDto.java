package com.example.beginner.dto;

import com.example.beginner.repository.MemberRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {

  MemberRepository memberRepository;
  private String title;
  private String content;
  private String author;
  private String password;

}
