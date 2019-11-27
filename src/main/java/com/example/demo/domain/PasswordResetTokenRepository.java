/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.domain;

import com.example.demo.domain.security.PasswordResetToken;
import java.util.Date;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Leyeseyi
 */
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long>{
    
    PasswordResetToken findByToken(String token);
    
    PasswordResetToken findByUser(User user);
    
    Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);
    
    @Modifying
    @Query("delete from PasswordResetToken t where t.expiryDate <= ?1")
    void deleteAllExpiredSince(Date now);
    
}
