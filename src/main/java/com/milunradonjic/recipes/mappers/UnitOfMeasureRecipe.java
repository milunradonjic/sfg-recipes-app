package com.milunradonjic.recipes.mappers;

import com.milunradonjic.recipes.domain.UnitOfMeasure;
import com.milunradonjic.recipes.dtos.UnitOfMeasureDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UnitOfMeasureRecipe extends BaseMapper<UnitOfMeasureDTO, UnitOfMeasure> {
}
