package com.example.ecommercebackend.converter;

import com.example.ecommercebackend.dto.OrderDTO;
import com.example.ecommercebackend.dto.OrderItemDTO;
import com.example.ecommercebackend.entity.OrderEntity;
import com.example.ecommercebackend.entity.OrderItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderConverter {

    public OrderEntity dtoToEntity(OrderDTO orderDTO, List<OrderItemEntity> orderItemList){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDate(orderDTO.getOrderDate());
        orderEntity.setTotalAmount(orderDTO.getTotalAmount());
        orderEntity.setOrderItems(orderItemList);
        orderEntity.setStatus(OrderEntity.Status.valueOf(orderDTO.getStatus().name()));;

        return orderEntity;
    }
    public OrderDTO entityToDto(OrderEntity orderEntity, List<OrderItemDTO> orderItemDTOList ) {
        OrderDTO dto = new OrderDTO();
        dto.setOrderDate(orderEntity.getOrderDate());
        dto.setTotalAmount(orderEntity.getTotalAmount());
        dto.setItems(orderItemDTOList);
        dto.setStatus(OrderDTO.Status.valueOf(orderEntity.getStatus().name()));
        return dto;
    }


}
