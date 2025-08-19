package Dev.practice.demo.service;

import Dev.practice.demo.DTO.Request.UserCreationRequest;
import Dev.practice.demo.DTO.Request.UserUpdateRequest;
import Dev.practice.demo.DTO.response.UserResponse;
import Dev.practice.demo.entity.User;
import Dev.practice.demo.exception.AppException;
import Dev.practice.demo.exception.ErrorCode;
import Dev.practice.demo.mapper.UserMapper;
import Dev.practice.demo.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {


     UserRepository userRepository;
     UserMapper userMapper;
    public User createUser(UserCreationRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
            User user = userMapper.toUser(request);

        return userRepository.save(user);

    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!")));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest updatedUser) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        userMapper.updateUser(user, updatedUser);

        return userMapper.toUserResponse(userRepository.save(user));

    }

    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return (" User " +  userId + " has been deleted");
    }
}
