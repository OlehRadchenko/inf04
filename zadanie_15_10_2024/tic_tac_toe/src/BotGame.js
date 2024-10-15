import React, { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { Link } from 'react-router-dom';

const BotGame = () => {
    const [board, setBoard] = useState(Array(9).fill(null));
    const [isXNext, setIsXNext] = useState(true);
    const [scores, setScores] = useState({ X: 0, O: 0 });
    const [winner, setWinner] = useState(null);
    const [difficulty, setDifficulty] = useState('easy');

    useEffect(() => {
        if (!isXNext && winner === null) {
            const timer = setTimeout(makeBotMove, 500);
            return () => clearTimeout(timer);
        }
    }, [isXNext, winner]);

    const handleClick = (index) => {
        if (board[index] || winner) return;

        const newBoard = board.slice();
        newBoard[index] = 'X';
        setBoard(newBoard);
        checkWinner(newBoard);
        setIsXNext(false);
    };

    const makeBotMove = () => {
        const newBoard = board.slice();
        let index;

        if (difficulty === 'easy') {
            do {
                index = Math.floor(Math.random() * 9);
            } while (newBoard[index]);
        } else {
            index = getBestMove(newBoard);
        }

        newBoard[index] = 'O';
        setBoard(newBoard);
        checkWinner(newBoard);
        setIsXNext(true);
    };

    const getBestMove = (newBoard) => {
        let bestScore = -Infinity;
        let move;

        for (let i = 0; i < 9; i++) {
            if (newBoard[i] === null) {
                newBoard[i] = 'O';
                const score = minimax(newBoard, 0, false);
                newBoard[i] = null;
                console.log(`Chce zrobić ruch ${i}, Wynik z algorytmu: ${score}`);
                if (score > bestScore) {
                    bestScore = score;
                    move = i;
                }
            }
        }
        return move;
    };

    const minimax = (board, depth, isMaximizing) => {
        const scores = { X: -1, O: 1, tie: 0 };
        const result = checkWinnerCondition(board);
        if (result !== null) {
            return scores[result] !== undefined ? scores[result] : 0;
        }

        if (isMaximizing) {
            let bestScore = -Infinity;
            for (let i = 0; i < 9; i++) {
                if (board[i] === null) {
                    board[i] = 'O';
                    bestScore = Math.max(bestScore, minimax(board, depth + 1, false));
                    board[i] = null;
                }
            }
            return bestScore;
        } else {
            let bestScore = Infinity;
            for (let i = 0; i < 9; i++) {
                if (board[i] === null) {
                    board[i] = 'X';
                    bestScore = Math.min(bestScore, minimax(board, depth + 1, true));
                    board[i] = null;
                }
            }
            return bestScore;
        }
    };

    const checkWinner = (newBoard) => {
        const result = checkWinnerCondition(newBoard);
        if (result) {
            setWinner(result);
            setScores(prevScores => ({ ...prevScores, [result]: prevScores[result] + 1 }));
        }
    };

    const checkWinnerCondition = (board) => {
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
            const [a, b, c] = line;
            if (board[a] && board[a] === board[b] && board[a] === board[c]) {
                return board[a];
            }
        }

        if (board.every(cell => cell)) {
            return 'Remis';
        }
        return null;
    };

    const resetGame = () => {
        setBoard(Array(9).fill(null));
        setWinner(null);
        setIsXNext(true);
    };

    return (
        <div className="game container mt-5">
            <h1 className="text-center">Kółko i Krzyżyk</h1>
            <div className="text-center mb-3">
                <h2>Gracz X: {scores.X} - Gracz O: {scores.O}</h2>
                <h3>{winner ? (winner === 'Remis' ? winner : `Wygrywa: ${winner}`) : `Kolej na: ${isXNext ? 'X' : 'O'}`}</h3>
                <h3>
                    <select value={difficulty} onChange={(e) => setDifficulty(e.target.value)}>
                        <option value="easy">Łatwy</option>
                        <option value="hard">Trudny</option>
                    </select>
                </h3>
                <h3><Link to="/" className="btn btn-secondary">Graj z Kolegą</Link></h3>
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

export default BotGame;