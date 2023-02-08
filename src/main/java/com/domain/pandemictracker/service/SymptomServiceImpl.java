package com.domain.pandemictracker.service;


import com.domain.pandemictracker.dto.SymptomDto;
import com.domain.pandemictracker.model.Symptom;
import com.domain.pandemictracker.repository.SymptomRepository;
import exception.SymptomNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class SymptomServiceImpl implements SymptomService {

    private static final Log LOGGER = LogFactory.getLog(SymptomServiceImpl.class);

    private final SymptomRepository symptomRepository;
    private final ConversionService conversionService;

    @Override
    public Set<SymptomDto> findByDiseaseName(String diseaseName) {
        return null;
    }

    @Override
    public SymptomDto findByDiseaseNameAndSymptomName(String diseaseName, String symptomName) throws SymptomNotFoundException {
        return null;
    }

    @Override
    public Symptom create(String name) {
        return null;
    }
}
