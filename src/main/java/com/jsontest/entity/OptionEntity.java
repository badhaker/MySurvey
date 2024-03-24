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
@Table(name = "options")
public class OptionEntity {
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String optionText;
    @ManyToOne
    @JoinColumn(name = "questionId")
    private QuestionEntity questionEntity;
    @OneToMany(mappedBy = "optionEntity", cascade = CascadeType.ALL)
    private List<SubQuestion> subQuestionList;
}
