package com.reviewduck.member.domain;

import static lombok.AccessLevel.*;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.reviewduck.member.exception.MemberException;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String socialId;

    private String nickname;

    private String profileUrl;

    public Member(String socialId, String nickname, String profileUrl) {
        validate(nickname);
        this.socialId = socialId;
        this.nickname = nickname;
        this.profileUrl = profileUrl;
    }

    private void validate(String nickname) {
        if (Objects.isNull(nickname) || nickname.isBlank()) {
            throw new MemberException("닉네임이 비어있을 수 없습니다.");
        }
    }
}
