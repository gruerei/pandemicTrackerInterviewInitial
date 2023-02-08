package com.domain.pandemictracker.controller;

import com.domain.pandemictracker.dto.DiseaseDto;
import com.domain.pandemictracker.service.DiseaseService;
import com.domain.pandemictracker.service.SymptomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.domain.pandemictracker.webUtils.UrlConstants.DISEASE_API_PATH;

@Slf4j
@RestController
@AllArgsConstructor
public class DiseaseController {

    private final DiseaseService diseaseService;
    private final SymptomService symptomService;


    @GetMapping(value = DISEASE_API_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<DiseaseDto>> getAll(){
        return ResponseEntity.ok(diseaseService.findAll());
    }

}
