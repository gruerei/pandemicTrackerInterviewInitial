package com.domain.pandemictracker.service;

import com.domain.pandemictracker.dto.SymptomDto;
import com.domain.pandemictracker.model.Symptom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class SymptomServiceTest {

    private static final String SYMPTOM1 = "Fatigue";
    private static final String SYMPTOM2 = "Runny Nose";

    private Set<Symptom> symptoms = new HashSet<>();
    private Symptom symptomObject1;
    private Symptom symptomObject2;


    @BeforeEach
    void setUp() {
        symptomObject1 = Symptom.builder().id(1).name(SYMPTOM1).build();
        symptomObject2 = Symptom.builder().id(2).name(SYMPTOM2).build();
        symptoms = buildSymptoms();
    }

    @Test
    void whenFindByDiseaseName_thenCheckSymptomsSet() {
    }

    @Test
    void whenFindByDiseaseNameAndSymptomName_thenCheckSymptomsName() {
    }

    @Test
    void whenFindByDiseaseNameAndSymptomNameNotFound_thenCheckSymptomNotFoundException() {
    }

    private Set<Symptom> buildSymptoms() {
        return Stream.of(symptomObject1,
                        symptomObject2)
                .collect(Collectors.toSet());
    }

    private Set<SymptomDto> buildSymptomsDto(Set<Symptom> symptoms) {
        return symptoms.stream()
                .map(symptom -> SymptomDto.builder().name(symptom.getName()).build())
                .collect(Collectors.toSet());
    }


}
