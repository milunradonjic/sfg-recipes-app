package com.milunradonjic.recipes.services.implementations;

import com.milunradonjic.recipes.domain.UnitOfMeasure;
import com.milunradonjic.recipes.repositories.UnitOfMeasureRepository;
import com.milunradonjic.recipes.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @Override
    public Set<UnitOfMeasure> findAll() {
        log.debug("Request to get all Units Of Measure");
        return (Set<UnitOfMeasure>) unitOfMeasureRepository.findAll();
    }

    @Override
    public UnitOfMeasure findById(Long id) {
        log.debug("Request to get UnitOfMeasure with id: {}", id);
        return unitOfMeasureRepository.findById(id).orElseThrow(() -> new RuntimeException("UniteOfMeasure with given id doesn't exist."));
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {
        log.debug("Request to save UnitOfMeasure");
        return unitOfMeasureRepository.save(unitOfMeasure);
    }

    @Override
    public void delete(UnitOfMeasure unitOfMeasure) {
        log.debug("Request to delete UnitOfMeasure");
        unitOfMeasureRepository.delete(unitOfMeasure);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Request to delete UnitOfMeasure with id: {}", id);
        unitOfMeasureRepository.deleteById(id);
    }

    @Override
    public UnitOfMeasure findByDescription(String description) {
        log.debug("Request to get UnitOfMeasure by description");
        return unitOfMeasureRepository.findByDescription(description).orElseThrow(() -> new RuntimeException("UnitOfMeasure with given description doesn't exist."));
    }
}
