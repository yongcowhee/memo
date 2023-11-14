package com.sparta.memo.entity;

import com.sparta.memo.dto.MemoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Memo extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}