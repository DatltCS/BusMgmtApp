import React, { useState, useEffect } from "react";
import "./BookingForm.css";
import Seat from "D:/Project LTJAVA/BusMgmtApp/Frontend/src/context/Seat.js";
import { useSearchParams } from "react-router-dom";
import Apis, {endpoints} from "../../../config/Apis";
import MySpinner from "../MySpinner";


function BookingForm() {
  const [firstFloorSeats, setFirstFloorSeats] = useState([]);
  const [secondFloorSeats, setSecondFloorSeats] = useState([]);
  const [selectedSeatId, setSelectedSeatId] = useState('');
  const [price, setSelectedPrice] = useState('');
  const [isChoosing, isSeatClicked] = useState(false);
  const [q] = useSearchParams();
  const [bustrips, setBusTrips] = useState(null);


  useEffect(() => {
    // Initialize the first and second floor seats arrays with Seat objects
    const firstFloorInitialSeats = [];
    const secondFloorInitialSeats = [];
    const columnCounts = [6, 5, 6]; // Define the number of seats in each column

    let seatId = 1;
    isSeatClicked(false);
    for (let col = 0; col < 3; col++) {
      for (let row = 0; row < columnCounts[col]; row++) {
        const newSeatA = new Seat(seatId, `A${seatId}`, false, false);
        // Generate seat objects for each column on the first floor
        firstFloorInitialSeats.push(newSeatA);

        // Generate seat objects for each column on the second floor (all labeled as B)
        const newSeatB = new Seat(seatId, `B${seatId}`, false, false);
        secondFloorInitialSeats.push(newSeatB);

        seatId++;
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


    setFirstFloorSeats(firstFloorInitialSeats);
    setSecondFloorSeats(secondFloorInitialSeats);
    loadBusTrips();
  }, []);

  const handleSeatClick = (seat) => {
    console.log('1' + seat.isChoosing);
    seat.isChoosing = !isChoosing;
    isSeatClicked(!isChoosing);
    console.log('2' + seat.isChoosing);

    // Update the selected seat information
    setSelectedSeatId(`${seat.floor}`);
    setSelectedPrice(bustrips.map(p=>p.price));
  };

  if ( bustrips === null)
  return <MySpinner />

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
                  className={`seat ${seat.isBooked ? "booked" : ""}`}
                  onClick={() => handleSeatClick(seat)}
                >
                  <img
                    src={
                      seat.isChoosing ? seat.seatImageChoosing : seat.seatImage
                    }
                    alt={`Seat ${seat.seatId}`}
                  />
                  <span>{seat.floor}</span>
                </div>
              ))}
            </div>
            <div className="column">
              {firstFloorSeats.slice(6, 11).map((seat) => (
                <div
                  key={seat.seatId}
                  className={`seat ${seat.isBooked ? "booked" : ""}`}
                  onClick={() => handleSeatClick(seat)}
                >
                  <img
                    src={
                      seat.isChoosing ? seat.seatImageChoosing : seat.seatImage
                    }
                    alt={`Seat ${seat.seatId}`}
                  />
                  <span>{seat.floor}</span>
                </div>
              ))}
            </div>
            <div className="column">
              {firstFloorSeats.slice(11, 17).map((seat) => (
                <div
                  key={seat.seatId}
                  className={`seat ${seat.isBooked ? "booked" : ""}`}
                  onClick={() => handleSeatClick(seat)}
                >
                  <img
                    src={
                      seat.isChoosing ? seat.seatImageChoosing : seat.seatImage
                    }
                    alt={`Seat ${seat.seatId}`}
                  />
                  <span>{seat.floor}</span>
                </div>
              ))}
            </div>
            <div className="column">
              {secondFloorSeats.slice(0, 6).map((seat) => (
                <div
                  key={seat.seatId}
                  className={`seat ${seat.isBooked ? "booked" : ""}`}
                  onClick={() => handleSeatClick(seat)}
                >
                  <img
                    src={
                      seat.isChoosing ? seat.seatImageChoosing : seat.seatImage
                    }
                    alt={`Seat ${seat.seatId}`}
                  />
                  <span>{seat.floor}</span>
                </div>
              ))}
            </div>
            <div className="column">
              {secondFloorSeats.slice(6, 11).map((seat) => (
                <div
                  key={seat.seatId}
                  className={`seat ${seat.isBooked ? "booked" : ""}`}
                  onClick={() => handleSeatClick(seat)}
                >
                  <img
                    src={
                      seat.isChoosing ? seat.seatImageChoosing : seat.seatImage
                    }
                    alt={`Seat ${seat.seatId}`}
                  />
                  <span>{seat.floor}</span>
                </div>
              ))}
            </div>
            <div className="column">
              {secondFloorSeats.slice(11, 17).map((seat) => (
                <div
                  key={seat.seatId}
                  className={`seat ${seat.isBooked ? "booked" : ""}`}
                  onClick={() => handleSeatClick(seat)}
                >
                  <img
                    src={
                      seat.isChoosing ? seat.seatImageChoosing : seat.seatImage
                    }
                    alt={`Seat ${seat.seatId}`}
                  />
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
            <label className="ghe-chon">Ghế đã chọn: {selectedSeatId} </label>
           
            <label className="tong-tien">Tổng tiền: {price}</label> 
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