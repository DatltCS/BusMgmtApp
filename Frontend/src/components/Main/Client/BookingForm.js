import React, { useState, useEffect } from 'react';
import "./BookingForm.css"

function BookingForm() {
    const [firstFloorSeats, setFirstFloorSeats] = useState([]);
    const [secondFloorSeats, setSecondFloorSeats] = useState([]);
    const [seat, isSeatClicked] = useState(false);

    useEffect(() => {
        // Initialize the first and second floor seats arrays with Seat objects
        const firstFloorInitialSeats = [];
        const secondFloorInitialSeats = [];
        const columnCounts = [6, 5, 6]; // Define the number of seats in each column

        let seatId = 1;

        for (let col = 0; col < 3; col++) {
            for (let row = 0; row < columnCounts[col]; row++) {
                // Generate seat objects for each column on the first floor
                firstFloorInitialSeats.push({
                    seatId,
                    seatImage: `/book-seat.png`,
                    isBooked: false,
                    floor: `A${seatId}`,
                });

                // Generate seat objects for each column on the second floor (all labeled as B)
                secondFloorInitialSeats.push({
                    seatId,
                    seatImage: `/book-seat.png`,
                    isBooked: false,
                    floor: `B${seatId}`,
                });

                seatId++;
            }
        }

        setFirstFloorSeats(firstFloorInitialSeats);
        setSecondFloorSeats(secondFloorInitialSeats);
    }, []);

    const handleSeatClick = () => {
        isSeatClicked(true);
    };

    return (
        <>
            <div id="bookingForm">
                <div id="seatSelection">
                    <label className="tang1">Tầng 1</label>
                    <label className="tang2">Tầng 2</label>
                    <div className="ticket-form">
                        <div className="column">
                            {firstFloorSeats.slice(0, 6).map((seat) => (
                                <div
                                    key={seat.seatId}
                                    className={`seat ${seat.isBooked ? 'booked' : ''}`}
                                    onClick={() => handleSeatClick(seat.seatId, seat.floor)}
                                >
                                    <img src={seat.seatImage} alt={`Seat ${seat.seatId}`} />
                                    <span>{seat.floor}</span>
                                </div>
                            ))}
                        </div>
                        <div className="column">
                            {firstFloorSeats.slice(6, 11).map((seat) => (
                                <div
                                    key={seat.seatId}
                                    className={`seat ${seat.isBooked ? 'booked' : ''}`}
                                    onClick={() => handleSeatClick(seat.seatId, seat.floor)}
                                >
                                    <img src={seat.seatImage} alt={`Seat ${seat.seatId}`} />
                                    <span>{seat.floor}</span>
                                </div>
                            ))}
                        </div>
                        <div className="column">
                            {firstFloorSeats.slice(11, 17).map((seat) => (
                                <div
                                    key={seat.seatId}
                                    className={`seat ${seat.isBooked ? 'booked' : ''}`}
                                    onClick={() => handleSeatClick(seat.seatId, seat.floor)}
                                >
                                    <img src={seat.seatImage} alt={`Seat ${seat.seatId}`} />
                                    <span>{seat.floor}</span>
                                </div>
                            ))}
                        </div>
                        <div className="column">
                            {secondFloorSeats.slice(0, 6).map((seat) => (
                                <div
                                    key={seat.seatId}
                                    className={`seat ${seat.isBooked ? 'booked' : ''}`}
                                    onClick={() => handleSeatClick(seat.seatId, seat.floor)}
                                >
                                    <img src={seat.seatImage} alt={`Seat ${seat.seatId}`} />
                                    <span>{seat.floor}</span>
                                </div>
                            ))}
                        </div>
                        <div className="column">
                            {secondFloorSeats.slice(6, 11).map((seat) => (
                                <div
                                    key={seat.seatId}
                                    className={`seat ${seat.isBooked ? 'booked' : ''}`}
                                    onClick={() => handleSeatClick(seat.seatId, seat.floor)}
                                >
                                    <img src={seat.seatImage} alt={`Seat ${seat.seatId}`} />
                                    <span>{seat.floor}</span>
                                </div>
                            ))}
                        </div>
                        <div className="column">
                            {secondFloorSeats.slice(11, 17).map((seat) => (
                                <div
                                    key={seat.seatId}
                                    className={`seat ${seat.isBooked ? 'booked' : ''}`}
                                    onClick={() => handleSeatClick(seat.seatId, seat.floor)}
                                >
                                    <img src={seat.seatImage} alt={`Seat ${seat.seatId}`} />
                                    <span>{seat.floor}</span>
                                </div>
                            ))}
                        </div>
                    </div>

                    <div className="seat-status">
                        <div className="picked-seat">
                            <img src="/sold-seat.png" alt="Sold Seat" />
                            <label>Ghế đã bán</label>
                        </div>
                        <div className="picking-seat">
                            <img src="/picking-seat.png" alt="Picking Seat" />
                            <label>Ghế đang chọn</label>
                        </div>
                    </div>
                </div>
                <div id="customerInfo">
                    <div className="seat-information">
                        <label className="ghe-chon">Ghế đã chọn </label>
                        <label></label>
                        <label className="ghe-chon">Tổng tiền</label>
                        <label>0đ</label>
                    </div>
                    <form id="infoForm">
                        <label htmlFor="name">Họ tên:</label>
                        <input type="text" id="name" name="name" required />
                        <label htmlFor="email">Email:</label>
                        <input type="email" id="email" name="email" required />
                        <label htmlFor="phone">Số điện thoại:</label>
                        <input type="tel" id="phone" name="phone" required />
                    </form>
                    <button className="continue-button">Tiếp tục</button>
                </div>
            </div>
        </>
    );
}

export default BookingForm;
