import React, { useState, useContext } from "react";
import './Banner.css';
import DropdownList from "./DropdownListStartPlace";
import Calendar from "./Calendar";
import { Link } from 'react-router-dom';
import Card from "./Card";
import OrderTickets from "../../../pages/OrderTickets";


const Banner = () => {
    const [isButtonClicked, setIsButtonClicked] = useState(false);

    // Function to handle button click
    const handleButtonClick = () => {
        setIsButtonClicked(true);
        // You can perform other actions here when the button is clicked.
    };

    const search = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`)
    }

    const optionsStartPlace = ['Kiên Giang', 'An Giang', 'Đồng Tháp', 'Long Xuyên', 'Cần Thơ'];
    const optionsDestination = ['Thành phố Hồ Chí Minh', 'Cần Thơ'];

    return (
    <>
        <section className='Main'>
            <div className="overlay-banner"></div>
            <div className="backgroundImage" style={{ backgroundImage: "url('/background.jpg')" }}></div>
            <div className="mainContent container">
                <div className="cardDiv grid">
                    <span className="textDiv">Tìm kiếm chuyến đi</span>
                </div>
                <div className="banner" onSubmit={search}>
                    <form action="#">
                        <div className="form-row">
                            <DropdownList label="Nơi xuất phát" options={optionsStartPlace} value={kw}
                    onChange={e => setKw(e.target.value)}/>
                            <img src="/flip.png" className="flip-icon" alt="flip" />
                            <DropdownList label="Nơi đến" options={optionsDestination} value={kw}
                    onChange={e => setKw(e.target.value)} />
                            <Calendar/>
                        </div>
                    </form>
                   <button className="btn-search" onClick={handleButtonClick}>Tìm chuyến</button>
                </div>
            </div>

        </section>
        {isButtonClicked === true ? <OrderTickets  /> : <Card/> }
        </>
    );
}

export default Banner;
