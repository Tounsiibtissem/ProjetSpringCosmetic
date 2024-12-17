package com.exemple.jpaapp1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.jpaapp1.model.User;
import com.exemple.jpaapp1.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setNom(userDetails.getNom());
            user.setPrenom(userDetails.getPrenom());
            user.setTelephone(userDetails.getTelephone());
            user.setEmail(userDetails.getEmail());
            user.setMot_de_passe(userDetails.getMot_de_passe());
            user.setRole(userDetails.getRole());
            return userRepository.save(user);
        }
        return null;
    }
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean authenticateUser(String email, String mot_de_passe) {
		// TODO Auto-generated method stub
		return false;
	}
}

