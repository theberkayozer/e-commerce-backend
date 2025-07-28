    package com.example.ecommercebackend.converter;

    import com.example.ecommercebackend.dto.OrderItemDTO;
    import com.example.ecommercebackend.dto.ProductDTO;
    import com.example.ecommercebackend.entity.OrderItemEntity;
    import com.example.ecommercebackend.entity.ProductEntity;
    import org.springframework.stereotype.Component;

    @Component
    public class OrderItemConverter {

        public OrderItemEntity dtoToEntity(OrderItemDTO orderItemDTO, ProductEntity productEntity){
            OrderItemEntity itemEntity=new OrderItemEntity();
            itemEntity.setPiece(orderItemDTO.getPiece());
            itemEntity.setTotalAmount(orderItemDTO.getTotalAmount());
            itemEntity.setProduct(productEntity);
            return  itemEntity;
        }
        public OrderItemDTO entityToDto(OrderItemEntity orderItemEntity, ProductDTO productDTO) {
            OrderItemDTO dto = new OrderItemDTO();
            dto.setPiece(orderItemEntity.getPiece());
            dto.setTotalAmount(orderItemEntity.getTotalAmount());
            dto.setProduct(productDTO);
            return dto;
        }
    }
