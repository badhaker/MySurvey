package com.jsontest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubQuestionRequest {
    private String subQuestionText;
    private List<SubOptionRequest> subOptionList;

}
