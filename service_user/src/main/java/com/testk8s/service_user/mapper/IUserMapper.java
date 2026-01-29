package com.testk8s.service_user.mapper;

import com.testk8s.service_user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    model.User toModel(User user);
    User toEntity(model.User user);
}
