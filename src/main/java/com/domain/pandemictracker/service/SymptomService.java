package com.domain.pandemictracker.service;

import com.domain.pandemictracker.dto.SymptomDto;
import com.domain.pandemictracker.model.Symptom;
import exception.SymptomNotFoundException;

import java.util.Set;

public interface SymptomService {
    Set<SymptomDto> findByDiseaseName(String diseaseName);

    SymptomDto findByDiseaseNameAndSymptomName(String diseaseName, String symptomName) throws SymptomNotFoundException;

    Symptom create(String name);

}
