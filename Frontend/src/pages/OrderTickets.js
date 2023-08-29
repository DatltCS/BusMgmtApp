import React from "react";
import { useSearchParams } from "react-router-dom";
import { useState, useEffect, useContext } from "react";
import "./OrderTickets.css"
import Apis, { endpoints } from "../config/Apis";
import DropdownListStartPlace from "../components/Main/DropdownListStartPlace";
import { Alert, Button, Card, Col, Row } from "react-bootstrap";
import Calendar from "../components/Main/Calendar";
import { Link } from 'react-router-dom';
import "../components/Main/Banner.css";
import BookingForm from "../components/Main/BookingForm";
import MySpinner from "../components/Main/MySpinner";



function OrderTickets({ showBusesList }) {
    const optionsStartPlace = ['Kiên Giang', 'An Giang', 'Đồng Tháp', 'Long Xuyên', 'Cần Thơ'];
    const optionsDestination = ['Thành phố Hồ Chí Minh', 'Cần Thơ'];

    const [isFormVisible, setIsFormVisible] = useState(false);

    const handleBookButtonClick = () => {
        setIsFormVisible(prevState => !prevState);
    };

    const [buses, setBuses] = useState(null);
    const [bustrips, setBusTrips] = useState(null);
    const [q] = useSearchParams();

    useEffect(() => {
        const loadBuses = async () => {
            try {
                let e = endpoints['buses'];

                let licensePlateId = q.get("licensePlateId");
                if (licensePlateId !== null)
                    e = `${e}?licensePlateId=${licensePlateId}`;
                else {
                    let kw = q.get("kw");
                    if (kw !== null)
                        e = `${e}?kw=${kw}`;
                }

                let res = await Apis.get(e);
                setBuses(res.data);
            } catch (ex) {
                console.error(ex);
            }
        }

        const loadBusTrips = async () => {
            try {

                let e = endpoints['bustrips'];

                let tripId = q.get("tripId");
                if (tripId !== null)
                    e = `${e}?tripId=${tripId}`;
                else {
                    let kw = q.get("kw");
                    if (kw !== null)
                        e = `${e}?kw=${kw}`;
                }

                let res = await Apis.get(e);
                // Set the bus trips data using setBusTrips function
                setBusTrips(res.data);
            } catch (ex) {
                console.error(ex);
            }
        };

        loadBusTrips();
        loadBuses();
    }, [q]);

    if (buses === null || bustrips === null)
        return <MySpinner />
    // if (buses=== null) 
    //     return <BusRegistration />



    // const getData = (data) => {
    //     console.log("Coming from Banner.js", data);
    // }


    return (

        <>
            {/*          
            {buses.map(b => {
                return ( */}
            <div className="mainContent container">
                <div className="banner">
                    <form action="#">
                        <div className="form-row">
                            <DropdownListStartPlace label="Nơi xuất phát" options={optionsStartPlace} storageKey="startPlace" />
                            <img src="/flip.png" className="flip-icon" alt="flip" />
                            <DropdownListStartPlace label="Nơi đến" options={optionsDestination} storageKey="destination" />
                            <Calendar />
                        </div>
                    </form>
                    <Link to="/order-tickets"><button className="btn-search">Tìm chuyến</button></Link>
                </div>
            </div>
            <div className={`${!showBusesList ? "active" : ""} show`}>
                <Col>

                    {buses.map(p => {
                        return <div className="bus-list">
                            <div className="bus-item">
                                <div className="icon"><img src="/clock.png" /></div>
                                <text className="label">{p.timeStart}</text>
                            </div>
                            <div className="bus-item">
                                <div className="icon"><img src="/bus.png" /></div>
                                <div className="label">
                                    <div className="bus-line">{p.tripName}</div>
                                </div>
                            </div>
                            <div className="bus-item">
                                <div className="icon"><img src="/seats.png" /></div>
                                <div className="label">
                                    <div className="bus-line">{p.totalSeat} chỗ trống</div>
                                    <div className="bus-info">Xe {p.busType}</div>

                                </div>
                            </div>
                            <div className="bus-item">
                                <div className="big-text">{p.price}</div>
                            </div>
                            <div className="bus-item">
                                <button className="center-button" onClick={handleBookButtonClick}>Chọn chỗ</button>

                            </div>

                        </div>
                    })}
                </Col>

                <div className="booking-form">
                    {isFormVisible && (
                        <BookingForm />
                    )}
                </div>
            </div>
            );
        </>

    );

}

export default OrderTickets;