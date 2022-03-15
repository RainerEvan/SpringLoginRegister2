package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.User;
import com.example.demo.repository.RegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public void saveUser(User user){
        Optional<User> currUser = registrationRepository.findUserByEmail(user.getEmail());

        if(currUser.isPresent()){
            throw new IllegalStateException("email taken");
        } 
        
        registrationRepository.save(user);
    }

    public User loginUser(User user){
        Optional<User> currUser = registrationRepository.findUserByEmailPassword(user.getEmail(), user.getPassword());

        if(!currUser.isPresent()){
            throw new IllegalStateException("email or password is invalid");
        }

        return(user);
    }

}
