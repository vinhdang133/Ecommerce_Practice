package Dev.practice.demo.mapper;


import Dev.practice.demo.dto.Request.UserCreationRequest;
import Dev.practice.demo.dto.Request.UserUpdateRequest;
import Dev.practice.demo.dto.response.UserResponse;
import Dev.practice.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request); //nhan ve creation request va tra ve class user


    void updateUser(@MappingTarget User user,UserUpdateRequest request);
    UserResponse toUserResponse(User user);
}
