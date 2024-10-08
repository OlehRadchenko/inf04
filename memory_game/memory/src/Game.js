import React from 'react';
import { useState, useEffect } from 'react';
import Card from './Card';
import Table from 'react-bootstrap/Table';

const Game = ({mode}) => {
    const [visibleCards, setVisibleCards] = useState(Array(16).fill(false));
    const [shuffledCards, setShuffledCards] = useState();
    const [countOpenCards, setCountOpenCards] = useState(0);
    const [openIndexes, setOpenIndexes] = useState([]);
    const [count, setCount] = useState(0);
    const [countPairs, setCountPairs] = useState(0);
    const [indexesPairs, setIndexesPairs] = useState([]);
    const [wait, setWait] = useState(false);
    const [win, setWin] = useState(false);

    const clickCard = (index) => {
        if(countOpenCards < 2){
            const newVisibleCards = [...visibleCards];
            newVisibleCards[index] = !newVisibleCards[index];
            setVisibleCards(newVisibleCards);
            setCountOpenCards(countOpenCards + 1);
            setOpenIndexes([...openIndexes, index]);
        }
    };
    const checkWin = (index1, index2) => {
        if(shuffledCards[index1].value === shuffledCards[index2].value){
            setCountPairs(countPairs + 1);
            setIndexesPairs([...indexesPairs, index1, index2]);
        }else{
            setTimeout(() => {
                const newVisibleCards = [...visibleCards];
                newVisibleCards[index1] = false;
                newVisibleCards[index2] = false;
                setVisibleCards(newVisibleCards);
            }, 1000);
        }
        setCountOpenCards(0);
        setOpenIndexes([]);
        setCount(count + 1);
    }
    const cards = [
        { value: "10", suit: "S" },
        { value: "9", suit: "S" },
        { value: "8", suit: "S" },
        { value: "7", suit: "S" },
        { value: "6", suit: "S" },
        { value: "5", suit: "S" },
        { value: "4", suit: "S" },
        { value: "3", suit: "S" },
        { value: "10", suit: "S" },
        { value: "9", suit: "S" },
        { value: "8", suit: "S" },
        { value: "7", suit: "S" },
        { value: "6", suit: "S" },
        { value: "5", suit: "S" },
        { value: "4", suit: "S" },
        { value: "3", suit: "S" }
    ];
    const schuffleCards = () => {
        const shuffled = [...cards];
        for (let i = shuffled.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [shuffled[i], shuffled[j]] = [shuffled[j], shuffled[i]];
        }
        setShuffledCards(shuffled);
    };

    useEffect(() => {
        if(countOpenCards === 2){
            checkWin(openIndexes[0], openIndexes[1]);
        }
    }, [countOpenCards]);

    useEffect(() => {
        if(16 === countPairs * 2){
            setWin(true);
        }
    }, [countPairs]);

    useEffect(() =>{
        schuffleCards();
    }, []);
    
    return (
        <div className="text-center">
            <h1>Memory GAME MODE: {mode}</h1>
            <div className="container">
                <h2>Prób: {count}</h2>
                <h2>Par znaleziono: {countPairs}</h2>
                {win ? <h1>Wygrales</h1> : null}
                <Table responsive>
                    <tbody>
                        <tr>
                            {shuffledCards ? shuffledCards.map((card, index) => (
                                index < 4 ?
                                <td key={index}>
                                    <Card key={index} value={card.value} suit={card.suit} visible={visibleCards[index]} onClick={openIndexes.includes(index) || indexesPairs.includes(index) || wait ? null : () => clickCard(index)} />
                                </td> : null
                            )) : null}
                        </tr>
                        <tr>
                            {shuffledCards ? shuffledCards.map((card, index) => (
                                index < 8 && index >= 4 ?
                                <td key={index}>
                                    <Card key={index} value={card.value} suit={card.suit} visible={visibleCards[index]} onClick={openIndexes.includes(index) || indexesPairs.includes(index) || wait ? null : () => clickCard(index)} />
                                </td> : null
                            )) : null}
                        </tr>
                        <tr>
                            {shuffledCards ? shuffledCards.map((card, index) => (
                                index < 12 && index >= 8 ?
                                <td key={index}>
                                    <Card key={index} value={card.value} suit={card.suit} visible={visibleCards[index]} onClick={openIndexes.includes(index) || indexesPairs.includes(index) || wait ? null : () => clickCard(index)} />
                                </td> : null
                            )) : null}
                        </tr>
                        <tr>
                            {shuffledCards ? shuffledCards.map((card, index) => (
                                index < 16 && index >= 12 ?
                                <td key={index}>
                                    <Card key={index} value={card.value} suit={card.suit} visible={visibleCards[index]} onClick={openIndexes.includes(index) || indexesPairs.includes(index) || wait ? null : () => clickCard(index)} />
                                </td> : null
                            )) : null}
                        </tr>
                    </tbody>
                </Table>
            </div>
        </div>
    )
}
export default Game;