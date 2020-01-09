package com.milunradonjic.recipes.services.implementations;

import com.milunradonjic.recipes.domain.Note;
import com.milunradonjic.recipes.repositories.NoteRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class NoteServiceImplTest {
    
    final Long ID = 1L;

    NoteServiceImpl noteService;

    @Mock
    NoteRepository noteRepository;


    Note note;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        noteService = new NoteServiceImpl(noteRepository);
        note = Note.builder().id(ID).build();
    }

    @Test
    public void findAllNotes() {
        Set<Note> notesData = new HashSet<>();
        notesData.add(note);

        when(noteRepository.findAll()).thenReturn(notesData);

        Set<Note> notes = noteService.findAll();
        assertEquals(notes.size(), 1);
        // verify that noteRepository is called only once
        verify(noteRepository, times(1)).findAll();
    }

    @Test
    public void findNoteByIdFound() {
        Optional<Note> optionalNote = Optional.ofNullable(note);
        when(noteRepository.findById(anyLong())).thenReturn(optionalNote);
        Note returnedNote = noteService.findById(ID);
        assertNotNull(returnedNote);
        assertEquals(ID, returnedNote.getId());
    }

    @Test(expected = RuntimeException.class)
    public void findNoteByIdNotFound() {
        Optional<Note> optionalNote = Optional.empty();
        when(noteRepository.findById(anyLong())).thenReturn(optionalNote);
        noteService.findById(ID);
    }

    @Test
    public void save() {
        Note noteToSave = Note.builder().build();
        when(noteRepository.save(any())).thenReturn(note);
        Note savedNote = noteService.save(noteToSave);
        assertNotNull(savedNote);
        assertEquals(ID, savedNote.getId());
    }

    @Test
    public void delete() {
        noteService.delete(note);
        verify(noteRepository).delete(any());
    }

    @Test
    public void deleteById() {
        noteService.deleteById(ID);
        verify(noteRepository).deleteById(anyLong());
    }


}