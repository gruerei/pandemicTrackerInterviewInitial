package com.domain.pandemictracker.repository;

import com.domain.pandemictracker.model.Symptom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface SymptomRepository extends CrudRepository<Symptom, Long> {

    @Query(value = "select d.symptoms from Disease d where d.name = :diseaseName ")
    Set<Symptom> findByDiseaseName(@Param("diseaseName") String diseaseName);

    @Query(value = "select s from Disease d join d.symptoms s where d.name = :diseaseName and s.name = :symptomName")
    Optional<Symptom> findByDiseaseNameAndSymptomName(@Param("diseaseName") String diseaseName,
                                                   @Param("symptomName") String symptomName);

    Optional<Symptom> findByName(String name);
}
