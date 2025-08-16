package Dev.practice.demo.service;

import Dev.practice.demo.dtoRequest.UserCreationRequest;
import Dev.practice.demo.dtoRequest.UserUpdateRequest;
import Dev.practice.demo.entity.User;
import Dev.practice.demo.exception.AppException;
import Dev.practice.demo.exception.ErrorCode;
import Dev.practice.demo.repository.UserRepository;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        user.setPassword(request.getPassword());

        return userRepository.save(user);

    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User updateUser(String userId, UserUpdateRequest updatedUser) {
        User user = getUserById(userId);
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setDob(updatedUser.getDob());
        user.setPassword(updatedUser.getPassword());

        return userRepository.save(user);

    }

    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return (" User " +  userId + " has been deleted");
    }
}
