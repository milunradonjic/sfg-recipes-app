package com.milunradonjic.recipes.services.implementations;

import com.milunradonjic.recipes.domain.Category;
import com.milunradonjic.recipes.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class CategoryServiceImplTest {

    final Long ID = 1L;

    CategoryServiceImpl categoryService;

    @Mock
    CategoryRepository categoryRepository;


    Category category;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceImpl(categoryRepository);
        category = Category.builder().id(ID).build();
    }

    @Test
    public void findAllCategorys() {
        Set<Category> categorysData = new HashSet<>();
        categorysData.add(category);

        when(categoryRepository.findAll()).thenReturn(categorysData);

        Set<Category> categorys = categoryService.findAll();
        assertEquals(categorys.size(), 1);
        // verify that categoryRepository is called only once
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    public void findCategoryByIdFound() {
        Optional<Category> optionalCategory = Optional.ofNullable(category);
        when(categoryRepository.findById(anyLong())).thenReturn(optionalCategory);
        Category returnedCategory = categoryService.findById(ID);
        assertNotNull(returnedCategory);
        assertEquals(ID, returnedCategory.getId());
    }

    @Test(expected = RuntimeException.class)
    public void findCategoryByIdNotFound() {
        Optional<Category> optionalCategory = Optional.empty();
        when(categoryRepository.findById(anyLong())).thenReturn(optionalCategory);
        categoryService.findById(ID);
    }

    @Test
    public void save() {
        Category categoryToSave = Category.builder().build();
        when(categoryRepository.save(any())).thenReturn(category);
        Category savedCategory = categoryService.save(categoryToSave);
        assertNotNull(savedCategory);
        assertEquals(ID, savedCategory.getId());
    }

    @Test
    public void delete() {
        categoryService.delete(category);
        verify(categoryRepository).delete(any());
    }

    @Test
    public void deleteById() {
        categoryService.deleteById(ID);
        verify(categoryRepository).deleteById(anyLong());
    }

}