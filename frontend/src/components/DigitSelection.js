import React, { useState } from 'react';

const DigitSelection = ({ onGenerate }) => {
  const [selectedDigits, setSelectedDigits] = useState([]);

  const handleCheckboxChange = (event) => {
    const value = parseInt(event.target.value, 10);
    if (event.target.checked) {
      setSelectedDigits((prev) => [...prev, value]);
    } else {
      setSelectedDigits((prev) => prev.filter(digit => digit !== value));
    }
  };

  const handleGenerateClick = () => {
    onGenerate(selectedDigits);
  };

  return (
    <div>
      {[2,4,7,9,0].map((_, index) => (
        <label key={index}>
          <input
            type="checkbox"
            value={_}
            onChange={handleCheckboxChange}
          />
          {_}
        </label>
      ))}
      <button onClick={handleGenerateClick} disabled={selectedDigits.length === 0}  >Generate Token</button>
    </div>
  );
};

export default DigitSelection;
