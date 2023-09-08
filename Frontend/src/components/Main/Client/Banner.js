import React, { useState, useRef, useEffect } from "react";
import './Banner.css';
import Calendar from "./Calendar";
import { Link } from 'react-router-dom';
import Card from "./Card";
import OrderTickets from "../../../pages/OrderTickets";
import { useNavigate } from 'react-router-dom';

const Banner = () => {
    const [isButtonClicked, setIsButtonClicked] = useState(false);
    const [selectedStartPlace, setSelectedStartPlace] = useState('');
    const [selectedDestination, setSelectedDestination] = useState('');
    const [startPlaceOpen, setStartPlaceOpen] = useState(false);
    const [destinationOpen, setDestinationOpen] = useState(false);
    const nav = useNavigate();

    const handleStartPlaceSelect = (option) => {
        setSelectedStartPlace(option);
        setStartPlaceOpen(false); // Close the Start Place dropdown
    };

    const handleDestinationSelect = (optionsDestination) => {
        setSelectedDestination(optionsDestination);
        setDestinationOpen(false); // Close the Destination dropdown
    };

    const search = (evt) => {
        evt.preventDefault();
        // Construct the URL with selectedStartPlace and selectedDestination
        nav(`/?startPlace=${selectedStartPlace}&destination=${selectedDestination}`);
    }

    let menuRef = useRef();

    useEffect(() => {
        let handler = (e) => {
            if (!menuRef.current.contains(e.target)) {
                setStartPlaceOpen(false); // Close the Start Place dropdown
                setDestinationOpen(false); // Close the Destination dropdown
            }
        };

        document.addEventListener('mousedown', handler);

        return () => {
            document.removeEventListener('mousedown', handler);
        };
    }, []);

    const optionsStartPlace = ['Kiên Giang', 'An Giang', 'Đồng Tháp', 'Long Xuyên', 'Cần Thơ'];
    const optionsDestination = ['Thành phố Hồ Chí Minh', 'Cần Thơ'];

    const handleButtonClick = () => {
        setIsButtonClicked(true);
    };

    return (
        <>
            <section className='Main'>
                <div className="overlay-banner"></div>
                <div className="backgroundImage" style={{ backgroundImage: "url('/background.jpg')" }}></div>
                <div className="mainContent container">
                    <div className="cardDiv grid">
                        <span className="textDiv">Tìm kiếm chuyến đi</span>
                    </div>
                    <div className="banner">
                        <form action="#" onSubmit={search}>
                            <div className="form-row">
                                <div className="custom-dropdown-container" ref={menuRef}>
                                    <div className="custom-dropdown">
                                        <label className="start-place">Start Place</label>
                                        <div
                                            className={`custom-dropdown-toggle ${startPlaceOpen ? 'active' : 'inactive'}`}
                                            id="dropdown-basic-start"
                                            onClick={() => setStartPlaceOpen(!startPlaceOpen)}
                                        >
                                            <input
                                                type="text"
                                                value={selectedStartPlace}
                                                onChange={(event) => setSelectedStartPlace(event.target.value)}
                                                placeholder="Start Place"
                                                name="startPlace"
                                                style={{ border: 'none' }}
                                            />
                                        </div>
                                        {startPlaceOpen && (
                                            <div className="custom-dropdown-menu">
                                                {optionsStartPlace.map((option, index) => (
                                                    <div
                                                        key={index}
                                                        className="custom-dropdown-item"
                                                        onClick={() => handleStartPlaceSelect(option)}
                                                    >
                                                        {option}
                                                    </div>
                                                ))}
                                            </div>
                                        )}
                                    </div>
                                </div>
                                <div className="custom-dropdown-container">
                                    <div className="custom-dropdown">
                                        <label className="destination">Destination</label>
                                        <div
                                             className={`custom-dropdown-toggle ${destinationOpen ? 'active' : 'inactive'}`}
                                             id="dropdown-basic-destination"
                                             onClick={() => setDestinationOpen(!destinationOpen)} // Use setDestinationOpen
                                        >
                                            <input
                                                type="text"
                                                value={selectedDestination}
                                                onChange={(event) => setSelectedDestination(event.target.value)}
                                                placeholder="Destination"
                                                name="destination"
                                                style={{ border: 'none' }}
                                            />
                                        </div>
                                        {destinationOpen && (
                                            <div className="custom-dropdown-menu">
                                                {optionsDestination.map((option, index) => (
                                                    <div
                                                        key={index}
                                                        className="custom-dropdown-item"
                                                        onClick={() => handleDestinationSelect(option)}
                                                    >
                                                        {option}
                                                    </div>
                                                ))}
                                            </div>
                                        )}
                                    </div>
                                </div>
                                <Calendar />
                            </div>
                        </form>
                        <button className="btn-search" onClick={handleButtonClick}>Tìm chuyến</button>
                    </div>
                </div>
            </section>
            {isButtonClicked === true ? <OrderTickets /> : <Card />}
        </>
    );
}

export default Banner;
