package com.alimentationAkonkwa.HeadFirst.dto;
import com.alimentationAkonkwa.HeadFirst.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private  String Password;
    private String role;
    public static UserDto fromEntity(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        return dto;
    }
    // Method to convert UserDto to User entity
    public User toEntity() {
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setRole(this.role);
        user.setPhoneNumber(this.phoneNumber);
        user.setPassword(this.getPassword());
        return user;
    }

}
