import React, { useState, useEffect } from "react";
import { Card, Row, Col, Button } from 'react-bootstrap';
import Apis, { endpoints } from "../../../config/Apis";
import MySpinner from "../MySpinner";

function BusOrderTicket() {

    const [bustrips, setBusTrips] = useState(null);

    const loadBusTrips = async () => {
        try {
            const res = await Apis.get(endpoints['bustrips']);
            setBusTrips(res.data);
        } catch (error) {
            console.error("Error loading bus trips:", error);
        }
    };

    const loadBuses = async () => {
        try {
            const res = await Apis.get(endpoints['buses']);
            setBusTrips(res.data);
        } catch (error) {
            console.error("Error loading bus trips:", error);
        }
    };

    useEffect(() => {
        loadBusTrips();
        loadBuses();
    }, []);

    if (bustrips === null)
        return <MySpinner />;
    return (
        <>
            <h1>Đặt vé cho khách hàng</h1>
            <Row>

                {bustrips.map(p => {
                    const h = `/?tripId=${p.tripId}`;
                    return (<Col xs={12} md={3} className="mt-2 mb-2">
                        <Card style={{ width: '18rem' }}>
                            <Card.Body to={h} key={p.tripId}>
                                <Card.Title>Chuyến {p.tripName}</Card.Title>
                                <Card.Subtitle className="mb-2 text-muted">Giờ chạy: {p.timeStart}</Card.Subtitle>
                                <Card.Subtitle className="mb-2 text-muted">Giờ dự kiến kết thúc: {p.timeStop}</Card.Subtitle>
                                <Card.Text>Số ghế: </Card.Text>
                                <Card.Text>Giá: {p.price}.000 </Card.Text>
                                <Button variant="primary">Đặt vé</Button>
                                <Card.Link href="#">Another Link</Card.Link>
                            </Card.Body>
                        </Card>
                    </Col>
                    );

                })}

            </Row>
        </>
    )
}

export default BusOrderTicket;