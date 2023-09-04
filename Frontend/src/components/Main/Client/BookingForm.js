import React from "react";
import "./BookingForm.css";

function BookingForm() {
    return (
        <>
            <div id="bookingForm">
                <div id="seatSelection">
                    <label className="tang1">Tầng 1</label>
                    <label className="tang2">Tầng 2</label>
                    <div className="ticket-form">

                        <div className="seat-choosing">
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                        </div>

                        <div className="seat-choosing">
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                        </div>
                        <div className="seat-choosing">
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                        </div>
                        <div />
                        <div className="seat-choosing">
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                        </div>
                        <div className="seat-choosing">
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                        </div>
                        <div className="seat-choosing">
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                            <img src="/book-seat.svg"></img>
                        </div>
                        <div />

                    </div>
                    <div className="seat-status">
                        <div className="picked-seat">
                            <img src="/sold-seat.svg"></img>
                            <label>Ghế đã bán</label>
                        </div>
                        <div className="picking-seat">
                            <img src="/picking-seat.svg"></img>
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
    )
}

export default BookingForm;