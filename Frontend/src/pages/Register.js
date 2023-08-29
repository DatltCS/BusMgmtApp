import { useContext, useState, useRef } from "react";
import { Button, Form } from "react-bootstrap";
import "./Register.css";


const Register = () => {
    const [user, setUser] = useState({
        "firstName":"",
        "lastName" :"",
        "username" :"",
        "password":"",
        "confirmPass":"",
})

    const change = (evt, field) => (
        setUser => (current => {           
             return {...current, field: evt.target.value}
            })
    )

    const avatar = useRef();

    return <>
        <h1 className="text-center text-info">ĐĂNG KÝ</h1>

        <Form className="register-form">
        
            <Form.Group className="mb-3" >
                <Form.Label>Tên đăng nhập</Form.Label>
                <Form.Control value={user.username} onChange={e => change(e, "username")} type="text" placeholder="Tên đăng nhập" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Mật khẩu</Form.Label>
                <Form.Control value={user.password} onChange={e => change(e, "username")} type="password" placeholder="Mật khẩu" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Xác nhận mật khẩu</Form.Label>
                <Form.Control value={user.confirmPass} onChange={e => change(e, "confirmPass")} type="password" placeholder="Xác nhận mật khẩu" />
            </Form.Group>

            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Button variant="info" type="submit">Đăng ký</Button>
            </Form.Group>
        </Form>
    </>
}

export default Register;