package com.domain.pandemictracker.service;


import com.domain.pandemictracker.dto.DiseaseDto;
import com.domain.pandemictracker.dto.SymptomDto;
import exception.DiseaseNotFoundException;

import java.util.Set;

public interface DiseaseService  {
    Set<DiseaseDto> findAll();

    DiseaseDto update(String diseaseName, DiseaseDto diseaseDto) throws DiseaseNotFoundException;

    DiseaseDto findByName(String name) throws DiseaseNotFoundException;

    DiseaseDto addSymptom(String diseaseName, SymptomDto symptomDto) throws DiseaseNotFoundException;

    void removeSymptom(String diseaseName, String symptomParam) throws DiseaseNotFoundException;
}
