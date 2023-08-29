import './App.css';
import React, {createContext, useReducer } from "react";
import { BrowserRouter as Router, BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "../src/components/Header/Navbar";
import Banner from "../src/components/Main/Banner";
import BusRegistration from "../src/pages/BusRegistration";
import SignIn from "../src/pages/SignIn";
import OrderTickets from "../src/pages/OrderTickets";
import cookie from "react-cookies";
import MyUserReducer from "../src/config/MyUserReducer";
import Register from './pages/Register';


export const MyUserContext = createContext();

const App = () => {
  //const [isShowLoginForm, setIsShowLoginForm] = useState(false);
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);


  // const handleLoginClick = () => {
  //   setIsShowLoginForm((isShowLoginForm) => !isShowLoginForm)
  // }
  return (

    <MyUserContext.Provider value={[user, dispatch]}>
    <BrowserRouter>
      <Navbar/>
        <Routes>
          <Route path="/home" element={<Banner />} />
          <Route path="/bus-registration" element={<BusRegistration />} />
          <Route path="/order-tickets" element={<OrderTickets showBusesList={true} />} />
          <Route path="/sign-in" element={<SignIn />}/>
          <Route path="/register" element={<Register />}/>
        </Routes>

    </BrowserRouter>
    </MyUserContext.Provider>
  );
}

export default App;
