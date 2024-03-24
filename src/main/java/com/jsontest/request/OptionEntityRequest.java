package com.jsontest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionEntityRequest {
    private String optionText;
    private List<SubQuestionRequest> subQuestionList;

}
