import React, {useState} from "react";
import "./Main.css";

const Calendar = () => {
    const [date, setDate] = useState();
    return (
        <div className="input-data">
             <label class = "travel-date">Ngày đi</label>
        <input type = "date" onChange={e=>setDate(e.target.value)}/>
        </div>
    );
};

export default Calendar;