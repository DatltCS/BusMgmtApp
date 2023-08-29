import React, { useContext } from 'react';
import { Link, useNavigate } from "react-router-dom";
import { MyUserContext } from "../../App";


import './Navbar.css';


function Navbar() {
  const [user, dispatch] = useContext(MyUserContext);

  const logout = () => {
    dispatch({
      "type": "logout"
    })
  }

  return (
    <header className="custom-header">
      <div className="logo">
        <Link to="/home" className="logo-link">
          <img src="/bus-stop.png" alt="Logo" />
          <span className="logo-text">CheapTicket</span>
        </Link>
      </div>
      <nav className="nav-menu">
        <ul>
          <li><a href="#">Quản lý đơn hàng</a></li>
          <li><Link to="/bus-registration">Đăng ký mở bán vé trên CheapTicket</Link></li>
          {user === null ? <>
            <li><Link to="/sign-in"><button className="login-button">Đăng nhập</button></Link></li>
            <li><Link to="/register"><button className="login-button">Đăng ký</button></Link></li>
          </> : <>
            <Link to="/home">
              <a>Chào {user.username}</a>
            </Link>
            <li><Link to="/register"><button className="login-button" onClick={logout}>Đăng xuất</button></Link></li>
          </>}
        </ul>
      </nav>

    </header>

  );
}

export default Navbar;