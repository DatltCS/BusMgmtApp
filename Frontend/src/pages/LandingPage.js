import React, {useState} from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "../components/Header/Navbar";
import Banner from "../components/Main/Banner";
import BusRegistration from "./BusRegistration";
import SignIn from "./SignIn";
import Card from "../components/Main/Card";
import OrderTickets from "./OrderTickets";

function LandingPage() {

    const[isShowLoginForm, setIsShowLoginForm] = useState(false);

    const handleLoginClick = () => {
        setIsShowLoginForm((isShowLoginForm) => !isShowLoginForm)
    }

    return (
        <Router>
             <Navbar handleLoginClick={handleLoginClick}/>
            <Routes>
                <Route path="/bus-registration"  element={<BusRegistration />} />
                <Route path="/sign-in"  element={<SignIn />} isShowLoginForm={isShowLoginForm}/>
                <Route path="/order-tickets" element ={<OrderTickets showBusesList={true}/>}/>
            </Routes>
            <Banner/>
            <Card/>
        </Router>
    );
}

export default LandingPage;
