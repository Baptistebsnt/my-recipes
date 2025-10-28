package org.cookingapi.cookingapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The username is required")
    @Size(min = 3, max = 15, message = "The username must be between 3 and 15 characters")
    @Column(nullable = false, unique = true)
    private String username;

    @Email(message = "The email must be valid")
    @NotBlank(message = "The email is required")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "The password is required")
    @Size(min = 6, message = "The password must be at least 6 characters long")
    @Column(nullable = false)
    private String password;

    private String role; // e.g., USER, ADMIN
}
