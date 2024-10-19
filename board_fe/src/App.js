import React, { useEffect, useState } from "react";
import {Link} from 'react-router-dom';
import './App.css';

function App() {
    const [boards, setBoards] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/boards')
            .then(response => response.json())
            .then(data => setBoards(data))
            .catch(error => console.log(error));
    }, []); // 빈 배열을 추가하여 컴포넌트가 처음 렌더링될 때만 실행되도록 합니다.

    return (
        <div className="App">
            <div className={"header"}>게시판</div>
            <ul>
                {boards.map((board) => (
                    <li key={board.id}>
                        <Link to={`/${board.id}`}>
                            <div className={"title"}>{board.title}</div>
                            <div className={"writer"}>{board.userId}</div>
                            <div className={"date"}>{new Date(board.regDate).toLocaleDateString()}</div>
                        </Link>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
