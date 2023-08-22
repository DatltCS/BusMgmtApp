import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';
import { useState } from 'react';
import SignIn from '../../pages/SignIn';
import Main from '../Main/Banner';

function Navbar({ handleLoginClick }) {
  const handleClick = () => {
    handleLoginClick()
  }

  return (
    <header className="custom-header">
      <div className="logo">
        <Link to="/" className="logo-link">
          <img src="/bus-stop.png" alt="Logo" />
          <span className="logo-text">CheapTicket</span>
        </Link>
      </div>
      <nav className="nav-menu">
        <ul>
          <li><a href="#">Quản lý đơn hàng</a></li>
          <li><Link to="/BusRegistration">Mở bán vé trên CheapTicket</Link></li>
          <li><Link to="/SignIn"><button className="login-button" onClick={handleClick}>Đăng nhập</button>
          </Link></li>
        </ul>
      </nav>
      
    </header>
   
  );
}

export default Navbar;