package com.domain.pandemictracker.service;

import com.domain.pandemictracker.dto.DiseaseDto;
import com.domain.pandemictracker.dto.SymptomDto;
import com.domain.pandemictracker.model.Disease;
import com.domain.pandemictracker.repository.DiseaseRepository;
import exception.DiseaseNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class DiseaseServiceImpl implements DiseaseService {

    private static final Log LOGGER = LogFactory.getLog(DiseaseServiceImpl.class);
    private final DiseaseRepository diseaseRepository;
    private final ConversionService conversionService;


    @Override
    public Set<DiseaseDto> findAll() {
        Iterable<Disease> diseases = diseaseRepository.findAll();
        return StreamSupport.stream(diseases.spliterator(), false)
                .map(d -> conversionService.convert(d, DiseaseDto.class))
            .collect(Collectors.toSet());
    }

    @Override
    public DiseaseDto update(String diseaseName, DiseaseDto diseaseDto) throws DiseaseNotFoundException {
        return null;
    }

    @Override
    public DiseaseDto findByName(String name) throws DiseaseNotFoundException {
        return null;
    }

    @Override
    public DiseaseDto addSymptom(String diseaseName, SymptomDto symptomDto) throws DiseaseNotFoundException {
        return null;
    }

    @Override
    public void removeSymptom(String diseaseName, String symptomParam) throws DiseaseNotFoundException {

    }


}
