package com.app.breadapp.services;

import com.app.breadapp.dtos.orderdtos.OrderDTO;

public interface OrderService {
    OrderDTO getOrder(Integer userId, Integer branchOfficeId);
}
