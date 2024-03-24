package com.jsontest.service;

import com.jsontest.entity.*;
import com.jsontest.repository.SurveyRepository;
import com.jsontest.request.SurveyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyService {
    @Autowired
    SurveyRepository surveyRepository;
    public String createSurvey(SurveyRequest surveyRequest) {
        Survey survey = new Survey();
        survey.setSurveyName(surveyRequest.getSurveyName());

        List<QuestionEntity> questionEntities = surveyRequest.getQuestionEntityList().stream()
                .map(questionRequest -> {
                    QuestionEntity questionEntity = new QuestionEntity();
                    questionEntity.setQuestionText(questionRequest.getQuestionText());
                    questionEntity.setSurveyId(survey);
                    List<OptionEntity> optionEntities = questionRequest.getOptionEntityList().stream()
                            .map(optionRequest -> {
                                OptionEntity optionEntity = new OptionEntity();
                                optionEntity.setOptionText(optionRequest.getOptionText());
                                optionEntity.setQuestionEntity(questionEntity);
                                List<SubQuestion> subQuestions = optionRequest.getSubQuestionList().stream()
                                        .map(subQuestionRequest -> {
                                            SubQuestion subQuestion = new SubQuestion();
                                            subQuestion.setSubQuestionText(subQuestionRequest.getSubQuestionText());
                                            subQuestion.setOptionEntity(optionEntity);
                                            List<SubOption> subOptions = subQuestionRequest.getSubOptionList().stream()
                                                    .map(subOptionRequest -> {
                                                        SubOption subOption = new SubOption();
                                                        subOption.setSubQuestion(subQuestion);
                                                        subOption.setOptionText(subOptionRequest.getOptionText());
                                                        return subOption;
                                                    })
                                                    .collect(Collectors.toList());

                                            subQuestion.setSubOptionList(subOptions);
                                            return subQuestion;
                                        })
                                        .collect(Collectors.toList());

                                optionEntity.setSubQuestionList(subQuestions);
                                return optionEntity;
                            })
                            .collect(Collectors.toList());

                    questionEntity.setOptionEntityList(optionEntities);
                    return questionEntity;
                })
                .collect(Collectors.toList());

        survey.setQuestionEntityList(questionEntities);

        surveyRepository.save(survey);

        return "Survey Saved";
    }
}
