package com.milunradonjic.recipes.mappers;

import com.milunradonjic.recipes.domain.Recipe;
import com.milunradonjic.recipes.dtos.RecipeDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RecipeMapper extends BaseMapper<RecipeDTO, Recipe> {
}
