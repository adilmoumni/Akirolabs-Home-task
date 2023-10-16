import React, { useState } from 'react';
import DigitSelection from './components/DigitSelection';
import './styles/App.css';

function App() {
  const [token, setToken] = useState('');
  const [validationResult, setValidationResult] = useState('');

  const handleGenerate = async (selectedDigits) => {
    try {
      const response = await fetch('http://localhost:8082/api/generate', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ availableDigits: selectedDigits }),
      });
      const data = await response.text();
      setToken(data);
    } catch (error) {
      console.error('Failed to generate token:', error);
    }
  };

  const handleTokenInputChange = (event) => {
    setToken(event.target.value);
  };

  const handleValidateToken = async () => {
    if (!token.trim()) {  // Check if token is empty or just whitespace
      setValidationResult('Token input is empty. Please enter a token.');
      return;
    }

    try {
      const response = await fetch('http://localhost:8081/api/validate', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ token: token }),
      });
      const isValid = await response.text();
      setValidationResult(isValid === 'true' ? 'Valid Token' : 'Invalid Token');
    } catch (error) {
      console.error('Failed to validate token:', error);
      setValidationResult('Error during validation.');
    }
  };

  return (
    <div className="App">
      <h1>Token Generator</h1>
      <DigitSelection onGenerate={handleGenerate} />
      <div>
        Token: 
        <input 
          value={token} 
          onChange={handleTokenInputChange} 
          style={{ width: '250px' }}
        />
        <button onClick={handleValidateToken}   disabled={!token.trim().match(/^\d{4}-\d{4}-\d{4}-\d{4}$/)}
 >Validate Token</button>
      </div>
      <div>
        Validation Result: {validationResult}
      </div>
    </div>
  );
}

export default App;
