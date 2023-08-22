import React from 'react'
import './SignIn.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
import Navbar from '../components/Header/Navbar';

// const defaultState = {
//     name: null,
//     email: null,
//     password: null,
//     nameError: null,
//     emailError: null,
//     passwordError: null
// }
const SignIn = ({isShowLogin}) => {
    // constructor() {
    //     super();
    //     this.state = defaultState;
    //     this.handleInputChange = this.handleInputChange.bind(this);
    // }
    // handleInputChange(event) {
    //     const target = event.target;
    //     var value = target.value;
    //     const name = target.name;
    //     this.setState({
    //         [name]: value
    //     });
    // }
    // validate() {
    //     let nameError = "";
    //     let emailError = "";
    //     let passwordError = "";
    //     if (!this.state.name) {
    //         nameError = "Name field is required";
    //     }
    //     const reg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    //     if (!this.state.email || reg.test(this.state.email) === false) {
    //         emailError = "Email Field is Invalid ";
    //     }
    //     if (!this.state.password) {
    //         passwordError = "Password field is required";
    //     }
    //     if (emailError || nameError || passwordError) {
    //         this.setState({ nameError, emailError, passwordError });
    //         return false;
    //     }
    //     return true;
    // }
    // submit() {
    //     if (this.validate()) {
    //         console.warn(this.state);
    //         this.setState(defaultState);
    //     }
    // }
   
        return (
            <>
            <div className="overlay">
                <div className={`${!isShowLogin ? "active" : ""}show `}>
                <main class="main-form">
                    <div class="sign-in-form">
                        <section class="wrapper">
                            <div class="heading">
                                <h1 class="text text-large">Đăng nhập</h1>
                                <p class="text text-normal">Chưa có tài khoản? <span><a href="#" class="text text-links">Tạo tài khoản</a></span>
                                </p>
                            </div>
                            <form name="signin" class="form">
                                <div class="input-control">
                                    <label for="email" class="input-label" hidden>Email </label>
                                    <input type="email" name="email" id="email" class="input-field" placeholder="Email" />
                                </div>
                                <div class="input-control">
                                    <label for="password" class="input-label" hidden>Mật khẩu</label>
                                    <input type="password" name="password" id="password" class="input-field" placeholder="Mật khẩu" />
                                </div>
                                <div class="input-control">
                                    <a href="#" class="text text-links">Quên mật khẩu</a>
                                    <input type="submit" name="submit" class="input-submit" value="Sign In" disabled />
                                </div>
                            </form>
                            <div class="striped">
                                <span class="striped-line"></span>
                                <span class="striped-text">Hoặc</span>
                                <span class="striped-line"></span>
                            </div>
                            <div class="method">
                                <div class="method-control">
                                    <a href="SignInGoogle" class="method-action">
                                        <i class="ion ion-logo-google"></i>
                                        <span>Đăng nhập bằng Google</span>
                                    </a>
                                </div>
                            </div>
                        </section>
                    </div>
                </main>
                </div>
            </div>
            </>
        )
    
}
export default SignIn;