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
@Table(name = "subQuestion")
public class SubQuestion {
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String subQuestionText;

    @ManyToOne
    @JoinColumn(name = "optionId")
    private OptionEntity optionEntity;

    @OneToMany(mappedBy = "subQuestion", cascade = CascadeType.ALL)
    private List<SubOption> subOptionList;
}
