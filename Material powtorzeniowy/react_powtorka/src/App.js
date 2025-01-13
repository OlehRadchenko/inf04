import { useState } from "react";

function App() {
  const staleCos = "Wpisz coś: ";
  const [cos, setCos] = useState(staleCos);
  const [iles, setIles] = useState(0);
  return (
    <div className="App">
      <h1>
        {cos}
      </h1>
      <input type="text" onChange={(e) => setCos(staleCos + e.target.value)}/>
      <button type="button" onClick={() => setIles(iles+1)}>Kliknąłeś już {iles} razy</button>
    </div>
  );
}

export default App;