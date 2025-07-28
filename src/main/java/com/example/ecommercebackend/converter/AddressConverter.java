package com.example.ecommercebackend.converter;

import com.example.ecommercebackend.dto.AddressDTO;
import com.example.ecommercebackend.entity.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    public AddressEntity dtoToEntity(AddressDTO addressDTO) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(addressDTO.getStreet());
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setCountry(addressDTO.getCountry());
        addressEntity.setPostalcode(addressDTO.getPostalcode());

        return addressEntity;

    }

    public AddressDTO entityToDto(AddressEntity addressEntity) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet(addressEntity.getStreet());
        addressDTO.setCity(addressEntity.getCity());
        addressDTO.setCountry(addressEntity.getCountry());
        addressDTO.setPostalcode(addressEntity.getPostalcode());
        return addressDTO;
    }


}
