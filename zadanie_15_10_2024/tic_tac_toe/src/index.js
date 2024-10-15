import React from 'react';
import ReactDOM from 'react-dom/client';
import TicTacToe from './TicTacToe';
import BotGame from './BotGame';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <Router>
    <Routes>
        <Route path="/" element={<TicTacToe />} />
        <Route path="/bot" element={<BotGame />} />
    </Routes>
  </Router>
);