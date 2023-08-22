import React, { useState } from "react";
import './Banner.css';
import DropdownListStartPlace from "./DropdownListStartPlace";
import DropdownListDestination from "./DropdownListDestination";
import Calendar from "./Calendar";

const Main = () => {
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
                            <DropdownListStartPlace />
                            <img src="/flip.png" className="flip-icon" alt="flip" />
                            <DropdownListDestination />
                            <Calendar/>
                        </div>
                    </form>
                    <button className="btn-search">Tìm chuyến</button>
                </div>
            </div>

        </section>

    );
}

export default Main;
