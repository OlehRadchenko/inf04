import { useLocation, useNavigate } from 'react-router-dom';

function Edit() {
  const navigate = useNavigate();
  const location = useLocation();
  const note_id = location.state.note_to_edit;
  const notes = location.state.notes;
  function editNote(tytul, tresc) {
    const data = new Date();
    const data_utworzenia_string = `${data.getHours()}:${data.getMinutes()}:${data.getSeconds()} ${data.getDate()}/${data.getMonth()+1}/${data.getFullYear()}`;
    const newNotes = [...notes];
    newNotes[note_id] = {note_id, tytul, tresc, data_utworzenia: data_utworzenia_string};
    if (JSON.stringify(newNotes) !== JSON.stringify(notes)) {
      navigate('/', {state: {notes: JSON.stringify(newNotes)}});
    }
  }  
  return (
      <div className="EditNotes">
        <form>
          <input type="text" id="title" placeholder={notes[note_id].tytul} />
          <input type="text" id="content" placeholder={notes[note_id].tresc} />
          <button type="button" onClick={() => editNote(document.getElementById('title').value, document.getElementById('content').value)}>Edit Note</button>
        </form>
      </div>
  );
}

export default Edit;
