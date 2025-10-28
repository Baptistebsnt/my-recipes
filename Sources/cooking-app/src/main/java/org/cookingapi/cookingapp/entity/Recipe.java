package org.cookingapi.cookingapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 100, message = "The title must be between 3 and 100 characters")
    @Column(nullable = false, unique = true)
    private String title;

    @Size(max = 500, message = "The description must be at most 500 characters")
    @Column(nullable = false)
    private String description;

    @Size(max = 2000, message = "The instructions must be at most 2000 characters")
    @Column(nullable = false)
    private String instructions;

    @Size(max= 1000, message = "The preparationTime must be at most 1000 minutes")
    private int preparationTime; // in minutes
}
