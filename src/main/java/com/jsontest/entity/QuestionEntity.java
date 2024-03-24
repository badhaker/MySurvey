package com.jsontest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question")
public class QuestionEntity {
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String questionText;
    @ManyToOne
    @JoinColumn(name = "surveyId")
    private Survey surveyId;
    @OneToMany(mappedBy = "questionEntity", cascade = CascadeType.ALL)
    private List<OptionEntity> optionEntityList;

}
