package com.reviewduck.template.dto.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@ToString
public class TemplateCreateRequest {

    @NotBlank(message = "템플릿의 제목은 비어있을 수 없습니다.")
    private String templateTitle;

    @NotNull(message = "템플릿의 설명 작성 중 오류가 발생했습니다.")
    private String templateDescription;

    @NotNull(message = "템플릿의 질문 목록 생성 중 오류가 발생했습니다.")
    private List<TemplateQuestionRequest> questions;
}
