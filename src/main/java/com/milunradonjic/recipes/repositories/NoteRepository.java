package com.milunradonjic.recipes.repositories;

import com.milunradonjic.recipes.domain.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
