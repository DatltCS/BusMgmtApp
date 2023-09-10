/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.pojo.Users;
import com.busmgmt.repository.UserRepository;
import com.busmgmt.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
//    @Autowired
//    private Cloudinary cloudinary;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = this.userRepository.getUserByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException("Invalid");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(users.getUserRole()));
        return new org.springframework.security.core.userdetails.User(
                users.getUsername(), users.getPassword(), authorities);
    }

    @Override
    public Users getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public boolean addUser(Users users) {
        String pass = users.getPassword();
        users.setPassword(this.passwordEncoder.encode(pass));
        users.setUserRole(Users.USER);
        users.setAccountStatus("enable");
//
//        int maxUserId = userRepository.getMaxUserId();
//        users.setUserId(maxUserId + 1);

        return this.userRepository.addUser(users);
    }

    @Override
    public boolean authUser(String username, String password) {
        return this.userRepository.authUser(username, password);
    }

    @Override
    public Users addUsers(Map<String, String> params, MultipartFile avatar) {
        Users u = new Users();
        u.setUsername(params.get("username"));
        u.setPassword(this.passwordEncoder.encode(params.get("password")));
        u.setUserRole("ROLE_USER");
        u.setAccountStatus("enabled");

        this.userRepository.addUser(u);
        return u;
    }

    @Override
    public List<Users> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public boolean registerBuscompanies(Users user) {
        user.setUserRole("ROLE_BUSCOMPANY");
        user.setIsCompany(Boolean.FALSE);
        return this.userRepository.registerBuscompanies(user);
    }

    @Override
    public Users geUserById(int id) {
        return this.userRepository.getUserById(id);
    }

}
