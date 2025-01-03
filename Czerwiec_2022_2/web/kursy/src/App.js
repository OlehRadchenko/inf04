import 'bootstrap/dist/css/bootstrap.css'
import './App.css';
import {useState} from 'react';

function App() {
  let kursy = ["Programowanie w C#", "Angular dla początkujących", "Kurs Django"];
  const [imie, setImie] = useState("");
  const [nrKursu, setNrKursu] = useState("");
  const wypisz = () =>{
    console.log(imie)
    if(nrKursu > 0 && nrKursu <= kursy.length){
      console.log(kursy[nrKursu-1])
    }else{
      console.log("Nieprawidłowy numer kursu")
    }
  }
  return (
    <div className="App">
      <h2>Liczba kursów: {kursy.length}</h2>
      <ol>
        {kursy.map((kurs) => <li key={kurs}>{kurs}</li>)}
      </ol>
      <form>
        <div className='form-group'>
          <label>Imię i nazwisko:</label>
          <input type='text' className='form-control' id='imieNazwisko' onChange={(e) => setImie(e.target.value)}/>
        </div>
        <div className='form-group m'>
          <label>Numer kursu:</label>
          <input type='number' className='form-control' id='numerKursu' onChange={(e) => setNrKursu(e.target.value)}/>
        </div>
        <div className='form-group'>
          <button type='button' className='btn btn-primary' id='przyciskZapisz' onClick={wypisz}>Zapisz do kursu</button>
        </div>
      </form>
    </div>
  );
}

export default App;