package com.milunradonjic.recipes.services.implementations;

import com.milunradonjic.recipes.domain.Note;
import com.milunradonjic.recipes.repositories.NoteRepository;
import com.milunradonjic.recipes.services.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    
    @Override
    public Set<Note> findAll() {
        log.debug("Request to get all Notes");
        return (Set<Note>) noteRepository.findAll();
    }

    @Override
    public Note findById(Long id) {
        log.debug("Request to get Note with id: {}", id);
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note with given id doesn't exist."));
    }

    @Override
    public Note save(Note note) {
        log.debug("Request to save Note");
        return noteRepository.save(note);
    }

    @Override
    public void delete(Note note) {
        log.debug("Request to delete Note");
        noteRepository.delete(note);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Request to delete Note with id: {}", id);
        noteRepository.deleteById(id);
    }
}
