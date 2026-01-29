package com.testk8s.service_product.mapper;

import com.testk8s.service_product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    model.Product toProduct(Product product);
    Product toEntity(model.Product product);
}
