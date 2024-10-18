import React, {useEffect, useState} from "react";
import './App.css';

function App() {
  const [boards, setBoards] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/boards')
        .then(response => response.json())
        .then(data => setBoards(data))
        .catch(error => console.log(error));
  });

  return (
      <div className="App">
        <div className={"header"}>게시판</div>
        <ul>
          {boards.map((board) => (
              <li key={board.id}>
                <div className={"title"}>{board.title}</div>
                <div className={"writer"}>{board.userId}</div>
                <div className={"date"}>{board.regDate}</div>
              </li>
          ))}
        </ul>
      </div>
  );
}

export default App;