import React from 'react';
import ReactDOM from 'react-dom/client';
import Notes from './Notes';
import Edit from './Edit';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Notes />} />
      <Route path="/edit" element={<Edit />} />
    </Routes>
  </BrowserRouter>
);