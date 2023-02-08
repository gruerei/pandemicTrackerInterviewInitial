package com.domain.pandemictracker.integration;

import com.domain.pandemictracker.dto.DiseaseDto;
import com.domain.pandemictracker.dto.SymptomDto;
import com.domain.pandemictracker.service.DiseaseCountryFacadeService;
import com.domain.pandemictracker.service.DiseaseService;
import com.domain.pandemictracker.service.SymptomService;
import exception.DiseaseNotFoundException;
import exception.SymptomNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IntegrationTest {

    private static final String COVID19 = "COVID-19";
    private static final String COVID23 = "COVID23";
    public static final String COUGH = "Cough";
    public static final String TIREDNESS_AND_FATIGUE = "tiredness and fatigue";

    @Autowired
    private DiseaseCountryFacadeService target;
    @Autowired
    private DiseaseService diseaseService;
    @Autowired
    private SymptomService symptomService;

    @Test
    void part1() throws SymptomNotFoundException {
        Set<DiseaseDto> diseases = diseaseService.findAll();
        assertEquals(10, diseases.size());

        Set<SymptomDto> covidSymptoms = symptomService.findByDiseaseName(COVID19);
        assertEquals(3, covidSymptoms.size());

        SymptomDto covidTiredness = symptomService.findByDiseaseNameAndSymptomName(COVID19, TIREDNESS_AND_FATIGUE);
        assertNotNull(covidTiredness);
    }

    @Test
    void part2() throws DiseaseNotFoundException {
        diseaseService.update(COVID19, DiseaseDto.builder().name(COVID23).build());
        assertEquals(COVID23, diseaseService.findByName(COVID23).getName());
        assertThrows(DiseaseNotFoundException.class, () -> diseaseService.findByName(COVID19));

        diseaseService.update(COVID23, DiseaseDto.builder().name(COVID19).build());
    }

    @Test
    void part3() throws SymptomNotFoundException, DiseaseNotFoundException {
        SymptomDto newCovidSymptom = SymptomDto.builder().name(COUGH).build();
        diseaseService.addSymptom(COVID19, newCovidSymptom);
        assertEquals(newCovidSymptom.getName(), symptomService.findByDiseaseNameAndSymptomName(COVID19, COUGH).getName());

        diseaseService.removeSymptom(COVID19, newCovidSymptom.getName());
        assertThrows(SymptomNotFoundException.class, () -> symptomService.findByDiseaseNameAndSymptomName(COVID19, COUGH));
    }
}
