package com.milunradonjic.recipes.mappers;

import com.milunradonjic.recipes.domain.Category;
import com.milunradonjic.recipes.dtos.CategoryDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = RecipeMapper.class)
public interface CategoryMapper extends BaseMapper<CategoryDTO, Category>{


}
