package com.milunradonjic.recipes.dtos;

import com.milunradonjic.recipes.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDTO {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Byte[] image;
    private Set<IngredientDTO> ingredients;
    private NoteDTO note;
    private Set<CategoryDTO> categories;

}
