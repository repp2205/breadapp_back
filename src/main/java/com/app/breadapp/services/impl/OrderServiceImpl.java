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
    public List<OrderDTO> getOrder(Integer userId, Integer branchOfficeId) {
        List<Object> objectsList = orderRepository.findByUserIdAndBranchOfficeId(userId);
        OrderDTO orderDTO = new OrderDTO();
        List<OrderDTO> orderDTOList = new ArrayList<>();

        if(!objectsList.isEmpty()) {
            List<ProductDTO> productList = new ArrayList<>();
            Integer orderId = (Integer) Arrays.asList((Object[])objectsList.get(0)).get(0);
            boolean dataPrymary = true;
            for(int i = 0; i < objectsList.size(); i++){
                List<?> orderOnList = Arrays.asList((Object[])objectsList.get(i));
                if(orderId != orderOnList.get(0)){
                    orderId = (Integer) orderOnList.get(0);
                    i--;
                    orderDTO.setProducts(productList);
                    orderDTOList.add(orderDTO);
                    dataPrymary = true;
                    orderDTO = new OrderDTO();
                    productList = new ArrayList<>();
                }else{
                    if(dataPrymary){
                        orderDTO.setOrderId(Integer.valueOf(orderOnList.get(0).toString()));
                        orderDTO.setOrderDate(orderOnList.get(1).toString());
                        orderDTO.setPickUpTime(orderOnList.get(2).toString());
                        orderDTO.setStatus(Integer.valueOf(orderOnList.get(3).toString()));
                        dataPrymary = false;
                    }

                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setId((Integer) orderOnList.get(4));
                    productDTO.setName((orderOnList.get(5)).toString());
                    productDTO.setCategory(orderOnList.get(6).toString());
                    productDTO.setImage(orderOnList.get(7).toString());
                    productDTO.setQuantity(Integer.valueOf(orderOnList.get(8).toString()));
                    productDTO.setTotal_amount((Double) orderOnList.get(9));
                    productList.add(productDTO);
                    orderId = (Integer) orderOnList.get(0);
                }
            }
            orderDTO.setProducts(productList);
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }
}
