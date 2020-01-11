package com.milunradonjic.recipes.controllers;

import com.milunradonjic.recipes.domain.Category;
import com.milunradonjic.recipes.dtos.CategoryDTO;
import com.milunradonjic.recipes.mappers.CategoryMapper;
import com.milunradonjic.recipes.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Api(tags = "Categories")
@Slf4j
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @ApiOperation(value = "Get all Categories")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<CategoryDTO> findAll() {
        log.debug("REST request to get all Categories");
        return categoryMapper.toDto(categoryService.findAll());
    }

    @ApiOperation(value = "Get Category by ID")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO findById(@PathVariable Long id) {
        log.debug("REST request to get Category by ID: {}", id);
        return categoryMapper.toDto(categoryService.findById(id));
    }

}
