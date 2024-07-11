package com.alimentationAkonkwa.HeadFirst.dto;

import com.alimentationAkonkwa.HeadFirst.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String phoneNumber;
    public static UserDto fromEntity(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        return dto;
    }

    // Method to convert UserDto to User entity
    public User toEntity() {
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPhoneNumber(this.phoneNumber);
        return user;
    }
}
