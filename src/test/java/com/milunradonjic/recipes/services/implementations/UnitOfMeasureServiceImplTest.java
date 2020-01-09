package com.milunradonjic.recipes.services.implementations;

import com.milunradonjic.recipes.domain.UnitOfMeasure;
import com.milunradonjic.recipes.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class UnitOfMeasureServiceImplTest {
    
    final Long ID = 1L;

    UnitOfMeasureServiceImpl unitOfMeasureService;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;


    UnitOfMeasure unitOfMeasure;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        unitOfMeasureService = new UnitOfMeasureServiceImpl(unitOfMeasureRepository);
        unitOfMeasure = UnitOfMeasure.builder().id(ID).build();
    }

    @Test
    public void findAllUnitOfMeasures() {
        Set<UnitOfMeasure> unitOfMeasuresData = new HashSet<>();
        unitOfMeasuresData.add(unitOfMeasure);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasuresData);

        Set<UnitOfMeasure> unitOfMeasures = unitOfMeasureService.findAll();
        assertEquals(unitOfMeasures.size(), 1);
        // verify that unitOfMeasureRepository is called only once
        verify(unitOfMeasureRepository, times(1)).findAll();
    }

    @Test
    public void findUnitOfMeasureByIdFound() {
        Optional<UnitOfMeasure> optionalUnitOfMeasure = Optional.ofNullable(unitOfMeasure);
        when(unitOfMeasureRepository.findById(anyLong())).thenReturn(optionalUnitOfMeasure);
        UnitOfMeasure returnedUnitOfMeasure = unitOfMeasureService.findById(ID);
        assertNotNull(returnedUnitOfMeasure);
        assertEquals(ID, returnedUnitOfMeasure.getId());
    }

    @Test(expected = RuntimeException.class)
    public void findUnitOfMeasureByIdNotFound() {
        Optional<UnitOfMeasure> optionalUnitOfMeasure = Optional.empty();
        when(unitOfMeasureRepository.findById(anyLong())).thenReturn(optionalUnitOfMeasure);
        unitOfMeasureService.findById(ID);
    }

    @Test
    public void save() {
        UnitOfMeasure unitOfMeasureToSave = UnitOfMeasure.builder().build();
        when(unitOfMeasureRepository.save(any())).thenReturn(unitOfMeasure);
        UnitOfMeasure savedUnitOfMeasure = unitOfMeasureService.save(unitOfMeasureToSave);
        assertNotNull(savedUnitOfMeasure);
        assertEquals(ID, savedUnitOfMeasure.getId());
    }

    @Test
    public void delete() {
        unitOfMeasureService.delete(unitOfMeasure);
        verify(unitOfMeasureRepository).delete(any());
    }

    @Test
    public void deleteById() {
        unitOfMeasureService.deleteById(ID);
        verify(unitOfMeasureRepository).deleteById(anyLong());
    }



}