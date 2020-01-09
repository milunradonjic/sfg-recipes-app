package com.milunradonjic.recipes.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoteDTO {

    private Long id;
    private RecipeDTO recipe;
    private String recipeNotes;

}
