package com.milunradonjic.recipes.services;

import com.milunradonjic.recipes.domain.Note;

import java.util.Set;

public interface NoteService {

    Set<Note> findAll();

    Note findById(Long id);

    Note save(Note note);

    void delete(Note note);

    void deleteById(Long id);
}
