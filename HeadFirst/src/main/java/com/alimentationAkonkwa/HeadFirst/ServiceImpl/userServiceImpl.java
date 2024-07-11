package com.alimentationAkonkwa.HeadFirst.ServiceImpl;

import com.alimentationAkonkwa.HeadFirst.exceptionHandler.UserAlreadyExistException;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.UserNotFoundException;
import com.alimentationAkonkwa.HeadFirst.models.User;
import com.alimentationAkonkwa.HeadFirst.repository.UserRepository;
import com.alimentationAkonkwa.HeadFirst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public userServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllClients() {
        return userRepository.findAll();
    }

    @Override
    public User createClient(User user) {
        if (userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistException("User already exists. Please check the user ID and try again.");
        }
        return userRepository.save(user);
    }

    @Override
    public User getClientById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found. Please check the user ID: " + id + " and try again."));
    }

    @Override
    public Boolean deleteClientById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found. Please check the user ID: " + id + " and try again.");
        }
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean updateClientById(Long id, User user) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found. Please check the user ID: " + id + " and try again.");
        }
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(userToUpdate);
        return true;
    }
}
