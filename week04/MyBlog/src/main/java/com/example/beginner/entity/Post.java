package com.example.beginner.entity;

import com.example.beginner.dto.PostRequestDto;
import com.example.beginner.dto.PostUpdateDto;
import com.example.beginner.repository.MemberRepository;
import com.example.beginner.util.SecurityUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends Timestamped {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String content;

  @Column(nullable = false)
  private String author;

  @JsonIgnore
  @Column(nullable = false)
  private String password;


  public Post(PostRequestDto postRequestDto) {

    this.title = postRequestDto.getTitle();
    this.content = postRequestDto.getContent();
    this.author = postRequestDto.getAuthor();
    this.password = postRequestDto.getPassword();
  }

  public void update(PostUpdateDto postUpdateDto) {
    this.title = postUpdateDto.getTitle();
    this.content = postUpdateDto.getContent();
  }

}
