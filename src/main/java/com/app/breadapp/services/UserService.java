package com.app.breadapp.services;

import com.app.breadapp.dtos.userdtos.RegisterDTO;
import com.app.breadapp.dtos.userdtos.UserDTO;

import javax.security.auth.login.CredentialException;

public interface UserService {
    String registerUser(RegisterDTO registerDTO) throws CredentialException;
    UserDTO getUser(String email, String password) throws Exception;
}
