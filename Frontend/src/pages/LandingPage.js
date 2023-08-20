import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "../components/Header/Navbar";
import Main from "../components/Main/Main";
import BusRegistration from "./BusRegistration";
import SignIn from "./SignIn";

function LandingPage() {
    return (
        <Router>
            <Navbar />
            <Routes>
                <Route path="/" element={<Main />} />
                <Route path="/BusRegistration"  element={<BusRegistration />} />
                <Route path="/SignIn"  element={<SignIn />} />
            </Routes>
        </Router>
    );
}

export default LandingPage;
