import { useState } from "react";

const Note = ({note, onSave, onCancel}) =>{
    const [tytul, setTytul] = useState("");
    const [tresc, setTresc] = useState("");

    return (
        <div>
            {note ? (
                <div>
                    <form>
                        <h1>EDYCJA</h1>
                        <input type="text" placeholder={note.tytul} onChange={(e) => setTytul(e.target.value)} value={tytul}/>
                        <input type="text" placeholder={note.tresc} onChange={(e) => setTresc(e.target.value)} value={tresc}/>
                        <button type="button" onClick={() => onSave({id: note.id, date: new Date().toLocaleDateString(), tytul, tresc})}>Zatwierdź</button>
                        <button type="button" onClick={onCancel}>Anuluj</button>
                    </form>
                </div>
            ) :
            (
                <div>
                    <form>
                        <h1>DODAWANIE</h1>
                        <input type="text" placeholder="Tytuł" onChange={(e) => setTytul(e.target.value)} value={tytul}/>
                        <input type="text" placeholder="Tresc" onChange={(e) => setTresc(e.target.value)} value={tresc}/>
                        <button type="button" onClick={() => onSave({tytul, tresc})}>Utwórz pierwszą notatkę</button>
                    </form>
                </div>
            )}
        </div>
    );
}

export default Note;