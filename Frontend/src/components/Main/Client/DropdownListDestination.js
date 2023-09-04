import React, { useState, useEffect, useRef, createContext } from 'react';
import './DropdownList.css';
import useLocalStorage from '../../../context/localStorage';



function DropdownListDestination({ label, options, storageKey }) {
  const [open, setOpen] = useState(false);
  const [selectedOption, setSelectedOption] = useState(null);
  const [value, setValue] = useLocalStorage(storageKey, '');


  const handleOptionSelect = (option) => {
    setSelectedOption(option);
    setValue(option);
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
          <label className="start-place">{label}</label>
          <div
            className={`custom-dropdown-toggle ${open ? 'active' : 'inactive'}`}
            id="dropdown-basic"
            onClick={() => setOpen(!open)}
          >
            <input
              type="text"
              value={value} 
              onChange={(event) => {
                const newValue = event.target.value;
                handleOptionSelect(newValue);
                setValue(newValue);
              }}
              placeholder={label}
              style={{ border: 'none' }}
            />
          </div>

          {open && (
            <div className="custom-dropdown-menu">
              {options.map((option, index) => (
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
