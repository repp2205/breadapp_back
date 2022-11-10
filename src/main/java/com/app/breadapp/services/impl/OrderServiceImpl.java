package com.app.breadapp.services.impl;

import com.app.breadapp.dtos.orderdtos.OrderDTO;
import com.app.breadapp.dtos.productdtos.ProductDTO;
import com.app.breadapp.dtos.userdtos.RegisterDTO;
import com.app.breadapp.dtos.userdtos.UserDTO;
import com.app.breadapp.entities.User;
import com.app.breadapp.repositories.OrderRepository;
import com.app.breadapp.repositories.UserRepository;
import com.app.breadapp.services.OrderService;
import com.app.breadapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;


    @Override
    public OrderDTO getOrder(Integer userId, Integer branchOfficeId) {
        List<Object> objectsList = orderRepository.findByUserIdAndBranchOfficeId(userId);
        OrderDTO orderDTO = new OrderDTO();
        List<ProductDTO> productDtoList = new ArrayList<>();

        if(!objectsList.isEmpty()){
            List<?> orderList;

            orderList = Arrays.asList((Object[])objectsList.get(0));
            orderDTO.setUserId(Integer.valueOf(orderList.get(0).toString()));
            orderDTO.setOrderDate(orderList.get(1).toString());
            orderDTO.setPickUpTime(orderList.get(2).toString());
            orderDTO.setStatus(Integer.valueOf(orderList.get(3).toString()));
            orderDTO.setProducts(productDtoList);

            for (int i = 0; i < objectsList.size(); i++){
                ProductDTO productDTO = new ProductDTO();
                orderList = Arrays.asList((Object[])objectsList.get(i));
                productDTO.setId(Integer.valueOf(orderList.get(4).toString()));
                productDTO.setName(orderList.get(5).toString());
                productDTO.setCategory(orderList.get(6).toString());
                productDTO.setImage(orderList.get(7).toString());
                productDTO.setQuantity(Integer.valueOf(orderList.get(8).toString()));
                productDTO.setTotal_amount(Double.valueOf(orderList.get(9).toString()));
                productDtoList.add(productDTO);
            }
        }
        return orderDTO;
    }
}
