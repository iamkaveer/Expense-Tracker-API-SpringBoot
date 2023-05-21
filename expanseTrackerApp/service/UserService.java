package com.expense.expanseTrackerApp.service;

import com.expense.expanseTrackerApp.Dto.SignInOutput;
import com.expense.expanseTrackerApp.Dto.UserSignInInput;
import com.expense.expanseTrackerApp.model.AuthenticationToken;
import com.expense.expanseTrackerApp.model.User;
import com.expense.expanseTrackerApp.repository.IUserRepo;
import com.expense.expanseTrackerApp.response.ResponseMessage;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    private IUserRepo iUserRepo;
    @Autowired
    private TokenService tokenService;

    //user sign up
    public ResponseEntity<?> signUp(User newUser) {
        // check if user exist or not
        User existUser = iUserRepo.findUserByEmail(newUser.getEmail());
        if(existUser != null){
            ResponseMessage errorResponse = new ResponseMessage("User with this email already exist..try sign-in!!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }else{
            String encryptedPassword = null;
            try {
                encryptedPassword = encryptPassword(newUser.getPassword());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            newUser.setPassword(encryptedPassword);
            iUserRepo.save(newUser);

            ResponseMessage successResponse = new ResponseMessage("User created..!!");
            return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
        }
    }
    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();
        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signIn(UserSignInInput userSignInInput) {
        User existUser = iUserRepo.findUserByEmail(userSignInInput.getEmail());
        if(existUser == null){
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }else {
            String encryptedPassword = null;
            try {
                encryptedPassword = encryptPassword(userSignInInput.getPassword());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            boolean isPasswordValid = encryptedPassword.equals(existUser.getPassword());
            if(!isPasswordValid){
                throw new IllegalStateException("User invalid!!!!...sign up instead");
            }

            AuthenticationToken token = new AuthenticationToken(existUser);
            tokenService.saveToken(token);
            //set up output response
            return new SignInOutput("Logged In Successfully !!!", token.getToken());
        }
    }

}
