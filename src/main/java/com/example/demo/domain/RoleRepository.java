/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.domain;

import com.example.demo.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Leyeseyi
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
