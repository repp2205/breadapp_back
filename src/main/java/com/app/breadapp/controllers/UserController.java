package com.app.breadapp.controllers;

import com.app.breadapp.bootmail.Html;
import com.app.breadapp.dtos.MessageErrorResponse;
import com.app.breadapp.dtos.MessageResponse;
import com.app.breadapp.dtos.orderdtos.PasswordDTO;
import com.app.breadapp.dtos.userdtos.RegisterDTO;
import com.app.breadapp.services.UserService;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialException;

@CrossOrigin(origins = "")
@RestController
@RequestMapping(value = "/user")
@Log4j2
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String ERROR  = "Error";



    @Autowired
    UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registerUser(@RequestBody RegisterDTO registerDTO){
        try {
            logger.info("Executing service registerUser. Request: {}", registerDTO);
            return ResponseEntity.status(HttpStatus.OK).body(userService.registerUser(registerDTO));
        }catch (Exception e){
            logger.error("Error in process: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageErrorResponse(e.getMessage()));
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUser(@RequestParam String email, @RequestParam String password){
        try {
            logger.info("Executing service getUser. Email: {}, password: {}", email, password);
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(email, password));
        }catch (CredentialException e){
            log.error(ERROR, e);
            return new ResponseEntity<>(new MessageErrorResponse(e.getMessage()),HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageErrorResponse(e.getMessage()),HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/recover")
    public ResponseEntity<Object> sendMail(@RequestParam String email){
        try{
            logger.info("Executing service recover. Email: {}", email);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(userService.recover(email)));
        } catch (BadCredentialsException e) {
            log.error(ERROR, e);
            return new ResponseEntity<>(new MessageErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageErrorResponse(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value ="/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> changePass(@PathVariable Integer userId, @RequestBody PasswordDTO passwordDTO){
        try{
            logger.info("Executing service changePass. userId: {}", userId);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(userService.changePass(userId, passwordDTO)));
        } catch (BadCredentialsException e) {
            log.error(ERROR, e);
            return new ResponseEntity<>(new MessageErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageErrorResponse(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
