package az.atl.coffeshopp.mapper;

import az.atl.coffeshopp.dao.entity.UserEntity;
import az.atl.coffeshopp.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDto fromEntityToDto(UserEntity user);

    UserEntity fromDtoToEntity(UserDto userDto);

    List<UserDto> fromEntityListToDtoList(List<UserEntity> users);
}
