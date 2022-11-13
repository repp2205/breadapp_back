package com.app.breadapp.services;

import com.app.breadapp.dtos.orderdtos.OrderIdDTO;
import com.app.breadapp.dtos.orderdtos.OrderRegisterDTO;
import com.app.breadapp.dtos.orderdtos.OrderUserDTO;

import java.util.List;

public interface OrderService {
    List<OrderUserDTO> getOrder(Integer userId, Integer branchOfficeId);
    OrderIdDTO registerOrder(OrderRegisterDTO orderRegisterDTO);
}
