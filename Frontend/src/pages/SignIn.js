import React, {useState, useContext} from 'react'
import './SignIn.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
import { MyUserContext } from "../App";
import Apis, { authApi, endpoints } from "../config/Apis";
import cookie from "react-cookies";
import { Navigate, useNavigate,useSearchParams  } from "react-router-dom";
import Button from 'react-bootstrap/Button';

const SignIn = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    const [q] = useSearchParams();

    const login = (evt) => {
        evt.preventDefault();
        
      
        const process = async () => {
            try {
                let res = await Apis.post(endpoints['login'], {
                    "username": username,
                    "password": password,
                });
                cookie.save("token", res.data);
                
                let {data} = await authApi().get(endpoints['current-user']);
                cookie.save("user", data);

                dispatch({
                    "type": "login",
                    "payload": data
                });
            } catch (err) {
                console.error(err);
            }
        }

        process();
    }

    if (user !== null) {
        let next = q.get("next") || "/";
        return <Navigate to={next} />
    }
   
        return (
            <>

                <div>
                <main class="main-form" onSubmit={login}>
                    <div class="sign-in-form">
                        <section class="wrapper">
                            <div class="heading">
                                
                                <h1 class="text text-large">Đăng nhập</h1>
                                <p class="text text-normal">Chưa có tài khoản? <span><a href="#" class="text text-links">Tạo tài khoản</a></span>
                                </p>
                            </div>
                            <form name="signin" class="form">
                                <div class="input-control">
                                    <label for="ten" class="input-label" hidden>Tên đăng nhập</label>
                                    <input type="text" name="ten" id="ten" class="input-field" value={username} onChange={e => setUsername(e.target.value)} placeholder="Tên đăng nhập" />
                                </div>
                                <div class="input-control">
                                    <label for="password" class="input-label" hidden>Mật khẩu</label>
                                    <input type="password" name="password" id="password" class="input-field" value={password} onChange={e => setPassword(e.target.value)} placeholder="Mật khẩu" />
                                </div>
                                <div class="input-control">
                                    <a href="#" class="text text-links">Quên mật khẩu</a>
                                    <input type="submit" name="submit" class="input-submit" value="Đăng nhập"  />
                                </div>
                            </form>
                            <div class="striped">
                                <span class="striped-line"></span>
                                <span class="striped-text">Hoặc</span>
                                <span class="striped-line"></span>
                            </div>
                            <Button variant="outline-primary">Hoặc đăng nhập bằng Google</Button>{' '}
                        </section>
                    </div>
                </main>
                </div>
            </>
        )
    
}
export default SignIn;