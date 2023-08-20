import React, { useState, useEffect, useRef } from 'react';
import './DropdownList.css';

function DropdownListDestination() {
  const [open, setOpen] = useState(false);
  const [selectedOption, setSelectedOption] = useState(null);

  const optionsDestination = ['Thành phố Hồ Chí Minh', 'Cần Thơ'];

  const handleOptionSelect = (option) => {
    setSelectedOption(option);
  };

  let menuRef = useRef();

  useEffect(() => {
    let handler = (e) => {
      if (!menuRef.current.contains(e.target)) {
        setOpen(false);
      }
    };

    document.addEventListener('mousedown', handler);

    return () => {
      document.removeEventListener('mousedown', handler);
    };
  }, []);

  return (
    <div className="custom-dropdown-container" ref={menuRef}>
      <div className="custom-dropdown">
        <label class = "start-place">Nơi đến</label>
        <div
          className={`custom-dropdown-toggle ${open ? 'active' : 'inactive'}`}
          id="dropdown-basic"
          onClick={() => setOpen(!open)}
        >
          {selectedOption || 'Nơi đến'}
        </div>

        {open && (
          <div className="custom-dropdown-menu">
            {optionsDestination.map((option, index) => (
              <div
                key={index}
                className="custom-dropdown-item"
                onClick={() => {
                  handleOptionSelect(option);
                  setOpen(false);
                }}
              >
                {option}
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}

export default DropdownListDestination;
