import React, { useState, useEffect } from 'react';
import './Game.css';

const BOARD_SIZE = 20;
const INITIAL_SNAKE = [
  { x: 8, y: 8 },
  { x: 7, y: 8 },
  { x: 6, y: 8 }
];
const DIRECTIONS = {
  ArrowUp: { x: 0, y: -1 },
  ArrowDown: { x: 0, y: 1 },
  ArrowLeft: { x: -1, y: 0 },
  ArrowRight: { x: 1, y: 0 }
};

const LEVELS = {
  easy: { speed: 300, obstacles: 0 },
  medium: { speed: 250, obstacles: 5 },
  hard: { speed: 200, obstacles: 10 }
};

const generateFood = () => {
  const x = Math.floor(Math.random() * BOARD_SIZE);
  const y = Math.floor(Math.random() * BOARD_SIZE);
  return { x, y };
};

const generateObstacles = (numObstacles, snake, food) => {
  const obstacles = [];
  while (obstacles.length < numObstacles) {
    const x = Math.floor(Math.random() * BOARD_SIZE);
    const y = Math.floor(Math.random() * BOARD_SIZE);
    if (
      !snake.some(segment => segment.x === x && segment.y === y) &&
      !(food.x === x && food.y === y)
    ) {
      obstacles.push({ x, y });
    }
  }
  return obstacles;
};

const isOppositeDirection = (newDirection, currentDirection) => {
  return (
    newDirection.x === -currentDirection.x && 
    newDirection.y === -currentDirection.y
  );
};

function Game() {
  const [snake, setSnake] = useState(INITIAL_SNAKE);
  const [food, setFood] = useState(generateFood());
  const [direction, setDirection] = useState(DIRECTIONS.ArrowRight);
  const [speed, setSpeed] = useState(LEVELS.easy.speed);
  const [isGameOver, setIsGameOver] = useState(false);
  const [score, setScore] = useState(0);
  const [difficulty, setDifficulty] = useState('easy');
  const [obstacles, setObstacles] = useState([]);
  const [bestScore, setBestScore] = useState(() => {
    const savedScore = localStorage.getItem('bestScore');
    return savedScore ? JSON.parse(savedScore) : 0;
  });

  useEffect(() => {
    const handleKeydown = (event) => {
      const newDirection = DIRECTIONS[event.key];
      if (newDirection && !isOppositeDirection(newDirection, direction)) {
        setDirection(newDirection);
      }
    };
    window.addEventListener('keydown', handleKeydown);
    return () => window.removeEventListener('keydown', handleKeydown);
  }, [direction]);

  useEffect(() => {
    if (isGameOver) return;

    const moveSnake = setInterval(() => {
      setSnake(prevSnake => {
        const newHead = {
          x: (prevSnake[0].x + direction.x + BOARD_SIZE) % BOARD_SIZE,
          y: (prevSnake[0].y + direction.y + BOARD_SIZE) % BOARD_SIZE
        };

        if (checkCollision(newHead, prevSnake) || checkObstacleCollision(newHead, obstacles)) {
          setIsGameOver(true);
          return prevSnake;
        }

        const newSnake = [newHead, ...prevSnake];
        if (newHead.x === food.x && newHead.y === food.y) {
          setFood(generateFood());
          setScore(prev => {
            const newScore = prev + 0.5;
            if (newScore > bestScore) {
              setBestScore(newScore);
              localStorage.setItem('bestScore', JSON.stringify(newScore));
            }
            return newScore;
          });
          setSpeed(prev => Math.max(50, prev - 10));
          if (difficulty !== 'easy') {
            setObstacles(generateObstacles(LEVELS[difficulty].obstacles, newSnake, food));
          }
        } else {
          newSnake.pop();
        }

        return newSnake;
      });
    }, speed);

    return () => clearInterval(moveSnake);
  }, [snake, direction, food, isGameOver, speed, obstacles, difficulty, bestScore]);

  const checkCollision = (head, snakeBody) => {
    return snakeBody.some(segment => segment.x === head.x && segment.y === head.y);
  };

  const checkObstacleCollision = (head, obstacles) => {
    return obstacles.some(obstacle => obstacle.x === head.x && obstacle.y === head.y);
  };

  const handleRestart = () => {
    setSnake(INITIAL_SNAKE);
    setFood(generateFood());
    setDirection(DIRECTIONS.ArrowRight);
    setIsGameOver(false);
    setScore(0);
    setSpeed(LEVELS[difficulty].speed);
    setObstacles(generateObstacles(LEVELS[difficulty].obstacles, INITIAL_SNAKE, food));
  };

  const handleDifficultyChange = (e) => {
    const selectedDifficulty = e.target.value;
    setDifficulty(selectedDifficulty);
    setSpeed(LEVELS[selectedDifficulty].speed);
    setObstacles(generateObstacles(LEVELS[selectedDifficulty].obstacles, snake, food));
  };

  return (
    <div className="app">
      <h1>Snake Game</h1>
      <p>Score: {score}</p>
      <p>Best Score: {bestScore}</p>

      <div>
        <label htmlFor="difficulty">Difficulty: </label>
        <select id="difficulty" value={difficulty} onChange={handleDifficultyChange} disabled={!isGameOver}>
          <option value="easy">Easy</option>
          <option value="medium">Medium</option>
          <option value="hard">Hard</option>
        </select>
      </div>

      {isGameOver ? (
        <div className="game-over">
          <h2 className="game-over-title">Game Over</h2>
          <p>Final Score: {score}</p>
          <button onClick={handleRestart}>Play Again</button>
        </div>
      ) : (
        <Board snake={snake} food={food} obstacles={obstacles} />
      )}
    </div>
  );
}

function Board({ snake, food, obstacles }) {
  const cells = Array.from({ length: BOARD_SIZE }, (_, y) =>
    Array.from({ length: BOARD_SIZE }, (_, x) => {
      const isSnake = snake.some(segment => segment.x === x && segment.y === y);
      const isFood = food.x === x && food.y === y;
      const isObstacle = obstacles.some(obstacle => obstacle.x === x && obstacle.y === y);
      return (
        <div
          key={`${x}-${y}`}
          className={`cell ${isSnake ? 'snake' : ''} ${isFood ? 'food' : ''} ${isObstacle ? 'obstacle' : ''} ${isFood ? 'food-animation' : ''}`}
        />
      );
    })
  );

  return <div className="board">{cells.flat()}</div>;
}

export default Game;