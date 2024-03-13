package com.devsuperior.dsComponentesInjecaoDep.service;

import com.devsuperior.dsComponentesInjecaoDep.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;
    public String total(Order order) {

        return "Exit\n" + " Code order: " + order.getCode() + "\n" + " Total value: "
                + ((order.getBasic() - order.getBasic() * (order.getDiscount()/100)) + shippingService.shipment(order));
    }
}
