import 'bootstrap/dist/css/bootstrap.css';
import { useState } from 'react';

function Form() {
  const [tytul, setTytul] = useState('');
  const [rodzaj, setRodzaj] = useState('');

  const onButtonClick = () =>{
    if(tytul == '' || rodzaj == ''){
      console.log('Wypełnij wszystkie pola');
    }else{
      console.log('Tytuł: ' + tytul + '; rodzaj: ' + rodzaj);
    }
  }

  return (
    <form>
      <div className='form-group'>
        <label>Tytuł filmu</label>
        <input id='tytul_input' type="text" className='form-control' placeholder="Wprowadź tytuł filmu" value={tytul} onChange={(e) => setTytul(e.target.value)}/><br/>
        <label>Rodzaj</label>
        <select id='rodzaj_input' className='form-control' placeholder="Wybierz rodzaj filmu" onChange={(e) => setRodzaj(e.target.value)}>
          <option value=""></option>
          <option value="1">Komedia</option>
          <option value="2">Obyczajowy</option>
          <option value="3">Sensacyjny</option>
          <option value="4">Horror</option>
        </select><br/>
        <button type="button" className="btn btn-primary" onClick={onButtonClick}>Dodaj</button>
      </div>
    </form>
  );
}

export default Form;