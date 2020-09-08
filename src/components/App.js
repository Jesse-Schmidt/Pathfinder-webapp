import React from 'react';
import './App.css';
import logo from './images/pathfinder.png';
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img className={"Image"} src={logo} alt={"Pathfinder Roleplaying Game"}/>
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
