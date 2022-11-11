package com.app.breadapp.services;

import com.app.breadapp.dtos.orderdtos.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrder(Integer userId, Integer branchOfficeId);
}
