package com.jsontest.repository;

import com.jsontest.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long> {
}
