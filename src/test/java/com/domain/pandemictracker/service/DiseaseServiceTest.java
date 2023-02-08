package com.domain.pandemictracker.service;

import com.domain.pandemictracker.dto.DiseaseDto;
import com.domain.pandemictracker.dto.SymptomDto;
import com.domain.pandemictracker.model.Disease;
import com.domain.pandemictracker.model.Symptom;
import com.domain.pandemictracker.repository.DiseaseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DiseaseServiceTest {

    private static final String DISEASE_NAME = "Dummy Disease Name";
    private static final String SYMPTOM_1_NAME = "first symptom";

    @Mock
    private DiseaseRepository diseaseRepository;

    @Mock
    private ConversionService conversionService;


    @InjectMocks
    private DiseaseServiceImpl target;

    private Symptom symptom;
    private Disease disease;
    private SymptomDto symptomDto;
    private DiseaseDto expectedDiseaseDto;

    @BeforeEach
    void setUp() {
        symptom = buildSymptom();
        disease = buildDisease(Stream.of(symptom).collect(Collectors.toSet()));
        symptomDto = SymptomDto.builder().name(SYMPTOM_1_NAME).build();
        expectedDiseaseDto = buildDiseaseDto(Stream.of(symptomDto).collect(Collectors.toSet()));
    }

    @Test
    void whenFindAllDiseases_thenCheckResponse() {
        when(diseaseRepository.findAll()).thenReturn(Collections.singletonList(disease));
        when(conversionService.convert(disease, DiseaseDto.class)).thenReturn(expectedDiseaseDto);

        Set<DiseaseDto> diseaseDtos = target.findAll();

        assertFalse(diseaseDtos.isEmpty());
        assertEquals(diseaseDtos, Stream.of(expectedDiseaseDto).collect(Collectors.toSet()));

    }

    @Test
    void whenFindByNameFound_thenCheckResponse() {

    }

    @Test
    void whenFindByNameNotFound_thenCheckException() {

    }


    @Test
    void whenUpdateFound_thenCheckResponse() {

    }

    @Test
    void whenAddSymptomOk_thenCheckResponse() {

    }

    @Test
    void whenRemoveSymptomOk_thenCheckResponse() {

    }


    private DiseaseDto buildDiseaseDto(Set<SymptomDto> symptomDtos) {
        return DiseaseDto.builder()
            .name(DISEASE_NAME)
            .symptoms(symptomDtos)
            .build();
    }

    private Symptom buildSymptom() {
        return Symptom.builder()
            .name(SYMPTOM_1_NAME)
            .build();
    }

    private Disease buildDisease(Set<Symptom> symptoms) {
        return Disease.builder()
            .id(1)
            .name(DISEASE_NAME)
            .isPandemic(true)
            .symptoms(symptoms)
            .build();
    }
}
