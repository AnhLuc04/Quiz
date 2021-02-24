package com.example.demo.service.user;

import com.example.demo.model.jwt.UserPrinciple;
import com.example.demo.model.user.User;
import com.example.demo.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAllByIsDeleted(1);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    public void remove(Long id) {
        userRepository.remove(id);
    }

    @Override
    public Iterable<User> findAllDeleted() {
        return userRepository.findAllByIsDeleted(0);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameAndIsDeleted(username,1);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
//        return null;
        return UserPrinciple.build(user);
    }
}
