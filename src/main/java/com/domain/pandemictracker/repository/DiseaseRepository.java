package com.domain.pandemictracker.repository;

import com.domain.pandemictracker.model.Disease;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DiseaseRepository extends CrudRepository<Disease, Long> {


    Optional<Disease> findByName(String diseaseName);
}
