import React, { useState, useContext } from "react";
import './Banner.css';
import DropdownList from "./DropdownListStartPlace";
import Calendar from "./Calendar";
import { Link } from 'react-router-dom';


const Main = () => {

    const optionsStartPlace = ['Kiên Giang', 'An Giang', 'Đồng Tháp', 'Long Xuyên', 'Cần Thơ'];
    const optionsDestination = ['Thành phố Hồ Chí Minh', 'Cần Thơ'];

    return (
        <section className='Main'>
            <div className="overlay-banner"></div>
            <div className="backgroundImage" style={{ backgroundImage: "url('/background.jpg')" }}></div>
            <div className="mainContent container">
                <div className="cardDiv grid">
                    <span className="textDiv">Tìm kiếm chuyến đi</span>
                </div>
                <div className="banner">
                    <form action="#">
                        <div className="form-row">
                            <DropdownList label="Nơi xuất phát" options={optionsStartPlace}/>
                            <img src="/flip.png" className="flip-icon" alt="flip" />
                            <DropdownList label="Nơi đến" options={optionsDestination}/>
                            <Calendar/>
                        </div>
                    </form>
                    <Link to="/order-tickets"><button className="btn-search">Tìm chuyến</button></Link>
                </div>
            </div>

        </section>

    );
}

export default Main;
