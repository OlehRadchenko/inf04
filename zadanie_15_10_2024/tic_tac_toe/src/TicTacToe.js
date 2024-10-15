import React, { useState } from 'react';
import { motion } from 'framer-motion';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { Link } from 'react-router-dom';

const TicTacToe = () => {
    const [board, setBoard] = useState(Array(9).fill(null))
    const [isXNext, setIsXNext] = useState(true)
    const [scores, setScores] = useState({ X: 0, O: 0 })
    const [winner, setWinner] = useState(null)

    const handleClick = (index) => {
        if (board[index] || winner) return
        
        const newBoard = board.slice()
        newBoard[index] = isXNext ? 'X' : 'O'
        setBoard(newBoard)
        setIsXNext(!isXNext)
        checkWinner(newBoard)
    };

    const checkWinner = (newBoard) => {
        const lines = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6],
        ];
        
        for (let line of lines) {
            const [a, b, c] = line
            if (newBoard[a] && newBoard[a] === newBoard[b] && newBoard[a] === newBoard[c]) {
                setWinner(newBoard[a])
                setScores(prevScores => ({ ...prevScores, [newBoard[a]]: prevScores[newBoard[a]] + 1 }))
                return
            }
        }
        
        if (newBoard.every(cell => cell)) {
            setWinner('Remis')
        }
    };

    const resetGame = () => {
        setBoard(Array(9).fill(null))
        if(winner === 'Remis') {
            Math.random() > 0.5 ? setIsXNext(true) : setIsXNext(false)
        }else if(winner === 'X') {
            setIsXNext(true)
        }else{
            setIsXNext(false)
        }
        setWinner(null)
    };

    return (
        <div className="game container mt-5">
            <h1 className="text-center">Kółko i Krzyżyk</h1>
            <div className="text-center mb-3">
                <h2>Gracz X: {scores.X} - Gracz O: {scores.O}</h2>
                <h3>{winner ? (winner === 'Remis' ? winner : `Wygrywa: ${winner}`) : `Kolej na: ${isXNext ? 'X' : 'O'}`}</h3>
                <h3><Link to="/bot" className="btn btn-secondary">Graj z Botem</Link></h3>
            </div>
            <div className="game">
                <div className="table">
                    {board.map((value, index) => (
                            <motion.div
                                key={index}
                                className="col-4"
                                initial={{ opacity: 0, scale: 0 }}
                                animate={{ opacity: 1, scale: 1 }}
                                exit={{ opacity: 0, scale: 0 }}
                                transition={{ duration: 0.3 }}
                            >
                            <div className="square" onClick={() => handleClick(index)}>
                                {value}
                            </div>
                        </motion.div>
                    ))}
                </div>
            </div>
            {winner ? <button className="btn btn-primary" onClick={resetGame}>Nowa Gra</button> : null}
        </div>
    );
};

export default TicTacToe;