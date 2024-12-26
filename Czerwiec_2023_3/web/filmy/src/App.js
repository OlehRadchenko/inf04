import 'bootstrap/dist/css/bootstrap.css';
import './App.css';
import { useState } from 'react';

function App() {
  const [tytul, setTytul] = useState('');
  const [rodzaj, setRodzaj] = useState('');
  const dodaj=()=>{
    if(tytul !== '' && rodzaj !== '')
      console.log("tytul: "+tytul+"; rodzaj: "+rodzaj);
    else
      console.log("Nie wszystkie dane zostały wprowadzone ;c")
  }
  return (
    <div className="App">
      <form>
        <div className="form-group">
          <label id="labelTitleFilm">Tytuł filmu</label>
          <input id="titleFilm" type="text" className="form-control" onChange={(e) => setTytul(e.target.value)}/>
        </div>
        <div className="form-group">
          <label id="labelGenreFilm">Rodzaj</label>
          <select id="genreFilm" className="form-control" onChange={(e) => setRodzaj(e.target.value)}>
            <option/>
            <option value="1">Komedia</option>
            <option value="2">Obyczajowy</option>
            <option value="3">Sensacyjny</option>
            <option value="4">Horror</option>
          </select>
        </div>
        <div className="form-group">
          <button id="addButton" type="button" className="btn btn-primary" onClick={dodaj}>Dodaj</button>
        </div>
      </form>
    </div>
  );
}

export default App;