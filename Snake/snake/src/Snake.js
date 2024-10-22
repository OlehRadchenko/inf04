import React from 'react';

const Snake = ({ snake }) => {
  return (
    <div className="snake">
      {snake.map((segment, index) => (
        <div key={index} className="snake-segment" style={{ top: segment[0] * 20, left: segment[1] * 20 }} />
      ))}
    </div>
  );
};

export default Snake;