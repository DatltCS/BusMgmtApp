import React, {useState} from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "../components/Header/Navbar";
import Banner from "../components/Main/Banner";
import BusRegistration from "./BusRegistration";
import SignIn from "./SignIn";
import Card from "../components/Main/Card";

function LandingPage() {

    const[isShowLoginForm, setIsShowLoginForm] = useState(false);

    const handleLoginClick = () => {
        setIsShowLoginForm((isShowLoginForm) => !isShowLoginForm)
    }

    return (
        <Router>
             <Navbar handleLoginClick={handleLoginClick}/>
            <Routes>
                <Route path="/" element={<Banner />} />
                <Route path="/BusRegistration"  element={<BusRegistration />} />
                <Route path="/SignIn"  element={<SignIn />} isShowLoginForm={isShowLoginForm}/>
            </Routes>
            <Card/>
        </Router>
    );
}

export default LandingPage;
