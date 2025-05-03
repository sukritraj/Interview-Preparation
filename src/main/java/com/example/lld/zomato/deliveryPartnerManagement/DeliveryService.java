package com.example.lld.zomato.deliveryPartnerManagement;

import com.example.lld.zomato.orderManagement.Order;
import com.example.lld.zomato.orderManagement.OrderStatus;
import com.example.lld.zomato.userManagement.DeliveryPartner;

import java.util.List;

public class DeliveryService {
    public DeliveryPartner assignDeliveryPartner(Order order, List<DeliveryPartner> partners) {
        if (order.getOrderStatus() != OrderStatus.CONFIRMED) {
            System.out.println("Order payment is incomplete. Cannot assign delivery.");
            return null;
        }
        for (DeliveryPartner partner : partners) {
            if (partner.isAvailable) {
                partner.isAvailable = false;
                return partner;
            }
        }
        return null;
    }
}
