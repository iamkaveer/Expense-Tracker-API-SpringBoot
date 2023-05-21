package com.expense.expanseTrackerApp.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignInInput {

    @Email(message = "invalid email address")
    @NotBlank(message = "email should not be blank")
    private String email;

    @NotBlank(message = "Password should not be blank")
    private String password;
}
