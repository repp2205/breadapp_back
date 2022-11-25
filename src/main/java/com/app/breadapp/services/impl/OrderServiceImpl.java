package com.app.breadapp.services.impl;

import com.app.breadapp.controllers.OrderController;
import com.app.breadapp.dtos.orderdtos.OrderIdDTO;
import com.app.breadapp.dtos.orderdtos.OrderRegisterDTO;
import com.app.breadapp.dtos.orderdtos.OrderStatusDTO;
import com.app.breadapp.dtos.orderdtos.OrderUserDTO;
import com.app.breadapp.dtos.productdtos.ProductDTO;
import com.app.breadapp.dtos.productdtos.ProductRegisterDTO;
import com.app.breadapp.entities.Order;
import com.app.breadapp.entities.OrderProduct;
import com.app.breadapp.repositories.OrderProducRepository;
import com.app.breadapp.repositories.OrderRepository;
import com.app.breadapp.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private static final String FORMAT_DATE_LONG = "yyyy-MM-dd HH:mm:ss";
    public static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderProducRepository orderProducRepository;

    @Override
    public List<OrderUserDTO> getOrder(Integer userId, Integer branchOfficeId) throws Exception {
        List<Object> objectsList;
        if(userId != null){
            objectsList = orderRepository.findByUserId(userId);
        }else if(branchOfficeId != null){
            objectsList = orderRepository.findByBranchOfficeid(branchOfficeId);
        }else{
            throw new Exception("Must send a branchOfficeId or userId");
        }
        OrderUserDTO orderDTO = new OrderUserDTO();
        List<OrderUserDTO> orderDTOList = new ArrayList<>();

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
                    orderDTO = new OrderUserDTO();
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
                    productDTO.setTotalAmount((Double) orderOnList.get(9));
                    productList.add(productDTO);
                    orderId = (Integer) orderOnList.get(0);
                }
            }
            orderDTO.setProducts(productList);
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }

    public OrderIdDTO registerOrder(OrderRegisterDTO orderRegisterDTO) {
        OffsetDateTime odt = OffsetDateTime.parse ( orderRegisterDTO.getPickUpTime()+".000+00" , DateTimeFormatter.ofPattern ( "yyyy-MM-dd HH:mm:ss.SSSX" ) ) ;
        Order order = new Order();
        order.setUserId(orderRegisterDTO.getUserId());
        order.setBranchOfficeid(orderRegisterDTO.getBranchOfficeId());
        order.setOrderDate(DateTimeFormatter.ofPattern(FORMAT_DATE_LONG).format((LocalDateTime.now().minusHours(5))));
        order.setPickUpTime(odt.minusHours(5).toString().substring(0, odt.toString().length()-1));
        order.setStatus(0);
        orderRepository.save(order);
        if(order.getId() != null){
            List<OrderProduct> orderProductList = new ArrayList<>();
            for (ProductRegisterDTO productRegisterDTO : orderRegisterDTO.getProducts()) {
                OrderProduct product = new OrderProduct();
                product.setOrderId(order.getId());
                product.setProductId(productRegisterDTO.getProductId());
                product.setQuantity(productRegisterDTO.getQuantity());
                product.setTotalAmount(productRegisterDTO.getTotalAmount());
                orderProductList.add(product);
            }
            orderProducRepository.saveAll(orderProductList);
        }
        return new OrderIdDTO(order.getId());
    }

    @Override
    public String updateOrderStatus(OrderStatusDTO orderStatusDTO, Integer orderId) throws Exception {
        Order order = orderRepository.findOrderById(orderId);
        if(order != null){
            order.setStatus(orderStatusDTO.getStatus());
            orderRepository.save(order);
            return "Ok";
        }else{
            throw new Exception("Order not exists");
        }
    }
}
