package com.reviewduck.review.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class QuestionAnswer {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private ReviewFormQuestion reviewFormQuestion;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Answer answer;

    @Column(nullable = false)
    private int position = -1;

    public QuestionAnswer(ReviewFormQuestion reviewFormQuestion, Answer answer) {
        this.reviewFormQuestion = reviewFormQuestion;
        this.answer = answer;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
