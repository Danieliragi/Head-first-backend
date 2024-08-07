package com.alimentationAkonkwa.HeadFirst.ServiceImpl;

import com.alimentationAkonkwa.HeadFirst.dto.UserDto;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.UserAlreadyExistException;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.UserNotFoundException;
import com.alimentationAkonkwa.HeadFirst.models.User;
import com.alimentationAkonkwa.HeadFirst.repository.UserRepository;
import com.alimentationAkonkwa.HeadFirst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements UserService {
    private final  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
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

        if (userRepository.existsByName(user.getName() ) && userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistException("User with with these details exist ");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean authenticate(String email, String rawPassword) {

        User user = (User) userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        // Verify the raw password against the stored hashed password
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }


    @Override
    public User getClientById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found, please  try again."));
    }

    @Override
    public Boolean deleteClientById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found, please  try again.");
        }
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean updateClientById(Long id, User user) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found, please  try again.");
        }
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(userToUpdate);
        return true;
    }
}
