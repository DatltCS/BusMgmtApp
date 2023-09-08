import React from "react";
import { useParams, useSearchParams } from "react-router-dom";
import { useState, useEffect, useContext } from "react";
import "./OrderTickets.css"
import Apis, { endpoints } from "../config/Apis";
import DropdownListStartPlace from "../components/Main/Client/DropdownListStartPlace";
import { Alert, Button, Card, Col, Row } from "react-bootstrap";
import Calendar from "../components/Main/Client/Calendar";
import { Link } from 'react-router-dom';
// import "../components/Main/Banner.css";
import BookingForm from "../components/Main/Client/BookingForm";
import MySpinner from "../components/Main/MySpinner";
import Comment from "../components/Main/Client/Comment";




function OrderTickets() {

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
    // // if (buses=== null) 
    //     return <BusRegistration />
    if (buses.length === 0 || bustrips.length === 0)
        return <Alert variant="info" className="mt-1">Không có chuyến đi nào!</Alert>

    // const getData = (data) => {
    //     console.log("Coming from Banner.js", data);
    // }

    return (

        <>
            <Col>

                {bustrips.map(p => {
                     let url = `/bustrips/${p.tripId}`;
                    return <div className="bus">
                        <div className="bus-list" >
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


                                <div className="label" key={p.tripId}>
                                    <div className="bus-line"> {p.licensePlateId.totalSeat} chỗ trống</div>
                                    <div className="bus-info">Xe {p.licensePlateId.busType}</div>

                                </div>

                            </div>

                            <div className="bus-item">
                                <div className="big-text">{p.price}.000</div>
                            </div>
                            <div className="bus-item">
                                <button className="center-button" onClick={handleBookButtonClick}>Chọn chỗ</button>

                            </div>

                            <Link to={url} className="btn btn-info" style={{marginTop: "22px"}} variant="primary">Xem chi tiết</Link>

                        </div>
                        

                    </div>
                })}
                <div className="booking-form">
                    {isFormVisible && (
                        <BookingForm />
                    )}
                </div>

            </Col>



        </>

    );

}

export default OrderTickets;