package com.alimentationAkonkwa.HeadFirst.service;
import com.alimentationAkonkwa.HeadFirst.dto.UserDto;
import com.alimentationAkonkwa.HeadFirst.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {
   private  final UserRepository userRepository;
@Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userRepository.findByName(username);
        if(userDto == null){
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }
        return User.builder()
                .username(userDto.getName())
                .password(userDto.getPassword())
                .roles(userDto.getRole())
                .build();
    }
}
