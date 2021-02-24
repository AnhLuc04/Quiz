package com.example.demo.service.user;


import com.example.demo.model.user.User;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService extends IGeneralService<User>, UserDetailsService {
    User findByUsername(String username);
}
