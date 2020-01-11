package com.milunradonjic.recipes.mappers;

import com.milunradonjic.recipes.domain.Note;
import com.milunradonjic.recipes.dtos.NoteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = RecipeMapper.class)
public interface NoteMapper extends BaseMapper<NoteDTO, Note> {

}
