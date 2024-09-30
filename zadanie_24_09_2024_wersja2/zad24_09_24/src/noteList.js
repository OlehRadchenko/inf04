import React, { useState } from 'react';
import Note from './note.js';

const NoteList = () =>{
    const [notes, setNotes] = useState([]);
    const [currentNote, setCurrentNote] = useState(null);
    const addNote = (note) => {
        if (note.id) {
          setNotes(notes.map((n) => (n.id === note.id ? note : n)));
        } else {
          note.id = Date.now();
          note.date = new Date().toLocaleDateString();
          setNotes([...notes, note]);
        }
        setCurrentNote(null);
      };
    
      const editNote = (id) => {
        const noteToEdit = notes.find((note) => note.id === id);
        setCurrentNote(noteToEdit);
      };
    
      const deleteNote = (id) => {
        setNotes(notes.filter((note) => note.id !== id));
      };
    
      const cancelEdit = () => {
        setCurrentNote(null);
      };

    return (
        <div>
            {currentNote ? (
                <Note
                    note={currentNote}
                    onSave={addNote}
                    onCancel={cancelEdit}
                />
            ) :
            notes.length === 0 ? (
                <div>
                    <h1>No Notes HERE ;c</h1>
                    <Note
                        onSave={addNote}
                    />
                </div>
            ) :
            (
                <div>
                {notes.map((note) => (
                    <div key={note.id}>
                        <h1>{note.tytul}</h1>
                        <h3>{note.tresc}</h3>
                        <h5>{note.date}</h5>
                        <button
                            onClick={() => editNote(note.id)}
                        >
                            Edit
                        </button>
                        <button
                            onClick={() => deleteNote(note.id)}
                        >
                            Delete
                        </button>
                    </div>
                ))}
                <button
                    onClick={() => setCurrentNote({tytul: "NewNote", tresc: "NewNote"})}>
                    Add New Note
                    </button>
                </div>
            )}
        </div>
    );
}

export default NoteList;