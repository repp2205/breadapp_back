package com.app.breadapp.services.impl;

import com.app.breadapp.dtos.userdtos.RegisterDTO;
import com.app.breadapp.dtos.userdtos.UserDTO;
import com.app.breadapp.entities.User;
import com.app.breadapp.repositories.UserRepository;
import com.app.breadapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String registerUser(RegisterDTO registerDTO) throws CredentialException {
        if(userRepository.findByEmail(registerDTO.getEmail()) == null){
            User user = new User();
            user.setBranchOfficeId(null);
            user.setBakeryId(null);
            user.setName(registerDTO.getName());
            user.setLastName(registerDTO.getLastName());
            user.setEmail(registerDTO.getEmail());
            user.setPhone(registerDTO.getPhone());
            user.setPassword(registerDTO.getPassword());
            user.setRole(registerDTO.getRole());
            user.setStatus(1);
            userRepository.save(user);
            return HttpStatus.CREATED.getReasonPhrase();
        }else{
            throw new CredentialException("Email "+ registerDTO.getEmail() + " is already registered");
        }
    }

    @Override
    public UserDTO getUser(String email, String password) throws Exception {
        User user = userRepository.findByEmailAndPassword(email, password);

        if(user != null){
            if(user.getStatus() == 1){
                UserDTO userDTO = new UserDTO();
                userDTO.setId(user.getId());
                userDTO.setBranchOfficeId(user.getBranchOfficeId());
                userDTO.setBakeryId(user.getBakeryId());
                userDTO.setName(user.getName());
                userDTO.setLastName(user.getLastName());
                userDTO.setEmail(user.getEmail());
                userDTO.setPhone(user.getPhone());
                userDTO.setRole(user.getRole());
                userDTO.setStatus(user.getStatus());
                return userDTO;
            }else{
                throw new CredentialException("User Not Active");
            }
        }else{
            throw new CredentialException("User Not Exists");
        }
    }
}
