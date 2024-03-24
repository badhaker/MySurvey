package com.jsontest.controller;

import com.jsontest.request.SurveyRequest;
import com.jsontest.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyController {
    @Autowired
    SurveyService surveyService;

    @PostMapping("/save")
    public String saveSurvey(@RequestBody SurveyRequest surveyRequest) {
        return surveyService.createSurvey(surveyRequest);
    }
}
