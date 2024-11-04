import React from 'react';

const Food = ({ position }) => {
  return (
    <div className="food" style={{ top: position[0] * 20, left: position[1] * 20 }} />
  );
};

export default Food;