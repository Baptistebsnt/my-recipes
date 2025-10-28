package org.cookingapi.cookingapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    public Long id;

    @NotBlank(message = "The username is required")
    @Size(min = 3, max = 15, message = "The username must be between 3 and 15 characters")
    public String username;

    @Email(message = "The email must be valid")
    @NotBlank(message = "The email is required")
    public String email;
}
