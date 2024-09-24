import { useState, useEffect } from "react";
import { Link, useLocation } from 'react-router-dom';

function Notes() {
  const location = useLocation();
  const save_notes = location.state?.notes;
  const [notes, setNotes] = useState([{id: 0, tytul: "Tytul", tresc: "Tresc", data_utworzenia: "11-11-11-111-11-11"}]);
  
  useEffect(() => {
    if (save_notes !== undefined) {
      setNotes([...save_notes]);
      console.log(notes);
    }else{
      setNotes([{id: 0, tytul: "Tytul", tresc: "Tresc", data_utworzenia: "11-11-11-111-11-11"}]);
    }
  }, [save_notes]);

  function addNote(tytul, tresc) {
    const data = new Date();
    const data_utworzenia_string = `${data.getHours()}:${data.getMinutes()}:${data.getSeconds()} ${data.getDate()}/${data.getMonth()+1}/${data.getFullYear()}`;
    setNotes([...notes, {id: notes.length, tytul, tresc, data_utworzenia: data_utworzenia_string}]);
    //<button type="button" onClick={() => setNotes(notes.filter((note, i) => i !== i))}>Delete</button>
  }
    return (
      <div className="Notes">
        <h1>Notes</h1>
        <ol>
          {notes.length > 0 ? notes.map((note, i) => (
            <li key={i}>
              <div className="note">
                <h3>{note.tytul}</h3>
                <p>{note.tresc}</p>
                <p>{note.data_utworzenia}</p>
                  <Link to={`/edit`} state={{note_to_edit: note.id, notes: notes}}>
                    <button type="button">Edit</button>
                  </Link>
              </div>
            </li>
          )) : <p>Brak notatek ;c</p>}
        </ol>
        
        <form>
          <input type="text" id="title" placeholder="Tytuł" />
          <input type="text" id="content" placeholder="Tresc" />
          <button type="button" onClick={() => addNote(document.getElementById('title').value, document.getElementById('content').value)}>Add Note</button>
        </form>
        <button type="button" onClick={() => setNotes([])}>Clear Notes</button>
      </div>
  );
}

export default Notes;
