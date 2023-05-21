package com.expense.expanseTrackerApp.controller;

import com.expense.expanseTrackerApp.Dto.SignInOutput;
import com.expense.expanseTrackerApp.Dto.UserSignInInput;
import com.expense.expanseTrackerApp.model.User;
import com.expense.expanseTrackerApp.service.TokenService;
import com.expense.expanseTrackerApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    //user sign-up
    @PostMapping("/user/signup")
    public ResponseEntity<?> userSignUp(@Valid @RequestBody User newUser){
        return userService.signUp(newUser);
    }

    //user sign-in
    @PostMapping("/user/signin")
    public SignInOutput userSignIn(@Valid @RequestBody UserSignInInput userSignInInput){
        return userService.signIn(userSignInInput);
    }

    //user sign out
    @DeleteMapping("/user/signout")
    public ResponseEntity<String> signOut(@RequestParam String email , @RequestParam String token){
        HttpStatus status;
        String msg=null;

        if(tokenService.authenticate(email,token))
        {
            tokenService.deleteToken(token);
            msg = "Signout Successful";
            status = HttpStatus.OK;
        }
        else
        {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>(msg , status);
    }
}
