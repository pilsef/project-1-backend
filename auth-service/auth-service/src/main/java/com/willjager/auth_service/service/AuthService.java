package com.willjager.auth_service.service;

import com.willjager.auth_service.payload.LoginDto;
import com.willjager.auth_service.payload.RegisterDto;

public interface AuthService {

    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);

}
