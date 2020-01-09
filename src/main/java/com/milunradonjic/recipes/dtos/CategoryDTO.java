package com.milunradonjic.recipes.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private Long id;
    private String description;
    private Set<RecipeDTO> recipes;
}
