import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';

function App() {

  const [imieNazwisko, setImieNazwisko] = useState('');
  const [kurs, setKurs] = useState('');
  const kursy = ["Programowanie w C#", "Angular dla początkujących", "Kurs Django"];
  
  const zapisz = () => {
    if(kurs <= kursy.length && kurs > 0){
      if(imieNazwisko !== '' && kurs !== '') {
        console.log(imieNazwisko)
        console.log(kursy[kurs-1])
      }else{
        console.log("Źle wprowadzone dane!")
      }
    }
    else{
      console.log("Nieprawidłowy numer kursu!")
    } 
  }
  
  return (
    <form>
      <div className="form-group">
        <h2>Liczba kursów: {kursy.length}</h2>
        <ol>
          {kursy.map((el, i) => <li key={i}>{el}</li>)}
        </ol>
        <label>Imie i nazwisko:</label>
        <input id="imieNazwisko" type="text" className='form-control' value={imieNazwisko} onChange={e => setImieNazwisko(e.target.value)}/><br/>
        <label>Numer kursu:</label>
        <input id="kurs" type='number' className='form-control' value={kurs} onChange={e => setKurs(e.target.value)}/><br/>
        <button type="button" className='btn btn-primary' onClick={zapisz}>Zapisz do kursu</button>
      </div>
    </form>
  );
}

export default App;