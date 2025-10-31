package com.willjager.auth_service.controller;

import com.willjager.auth_service.entity.Role;
import com.willjager.auth_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/roles")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> addRole(@RequestBody String roleName) {
        Role response = roleService.addRole(roleName);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
