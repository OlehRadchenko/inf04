import React from 'react';
import ReactDOM from 'react-dom/client';
import NoteList from './noteList.js';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <NoteList />
  </React.StrictMode>
);