package com.milunradonjic.recipes.services;

import com.milunradonjic.recipes.domain.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasure> findAll();

    UnitOfMeasure findById(Long id);

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure);

    void delete(UnitOfMeasure unitOfMeasure);

    void deleteById(Long id);

    UnitOfMeasure findByDescription(String description);
}
