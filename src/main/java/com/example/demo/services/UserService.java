/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.domain.User;
import com.example.demo.domain.security.PasswordResetToken;
import com.example.demo.domain.security.UserRole;
import java.util.Set;

/**
 *
 * @author Leyeseyi
 */
public interface UserService {
    PasswordResetToken getPasswordResetToken(final String token);
    
    void createPasswordResetTokenForUser(final User user, final String token);
    
    User findByUsername(String username);
    
    User findByEmail(String email);
    
    User createUser(User user, Set<UserRole> userRoles);
    
    User save(User user);
    
}
