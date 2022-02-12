package com.task.demo.model.mapper;

import com.task.demo.model.dto.UserDto;
import com.task.demo.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    List<UserDto> usersToUsersDto (List<User> users);

    List<User> usersDtoToUsers (List<UserDto> usersDto);

}
