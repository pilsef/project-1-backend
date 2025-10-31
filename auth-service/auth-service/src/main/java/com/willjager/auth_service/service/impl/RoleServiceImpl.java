package com.willjager.auth_service.service.impl;

import com.willjager.auth_service.entity.Role;
import com.willjager.auth_service.repository.RoleRepository;
import com.willjager.auth_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addRole(String roleName) {
        Role role = new Role();
        role.setName(roleName);
        return roleRepository.save(role);
    }
}
