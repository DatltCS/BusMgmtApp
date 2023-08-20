import React from 'react'
import './SignIn.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
const defaultState = {
    name: null,
    email: null,
    password: null,
    nameError: null,
    emailError: null,
    passwordError: null
}
class SignIn extends React.Component {
    constructor() {
        super();
        this.state = defaultState;
        this.handleInputChange = this.handleInputChange.bind(this);
    }
    handleInputChange(event) {
        const target = event.target;
        var value = target.value;
        const name = target.name;
        this.setState({
            [name]: value
        });
    }
    validate() {
        let nameError = "";
        let emailError = "";
        let passwordError = "";
        if (!this.state.name) {
            nameError = "Name field is required";
        }
        const reg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        if (!this.state.email || reg.test(this.state.email) === false) {
            emailError = "Email Field is Invalid ";
        }
        if (!this.state.password) {
            passwordError = "Password field is required";
        }
        if (emailError || nameError || passwordError) {
            this.setState({ nameError, emailError, passwordError });
            return false;
        }
        return true;
    }
    submit() {
        if (this.validate()) {
            console.warn(this.state);
            this.setState(defaultState);
        }
    }
    render() {
        return (
            <>
            <div className="container-sign-in">
                    <img src="/bus-bg.png" alt="Background" />
                <div className="login-content">
                    <form className='sign-in-form'>
                        <h2 className="title">WELCOME</h2>
                        <div className="input-div one">
                            <div className="i">
                                <i className="fas fa-user"></i>
                            </div>
                            <div className="div">
                                <h5>Username</h5>
                                <input type="text" className="input" />
                            </div>
                        </div>
                        <div className="input-div pass">
                            <div className="i">
                                <i className="fas fa-lock"></i>
                            </div>
                            <div className="div">
                                <h5>Password</h5>
                                <input type="password" className="input" />
                            </div>
                        </div>
                        <a href="#">Forgot Password?</a>
                        <input type="submit" className="btn" value="Login" />
                    </form>
                </div>
            </div>
            </>
        )
    }
}
export default SignIn;