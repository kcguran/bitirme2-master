package com.kcguran.bitirme.security.jwt;

import com.kcguran.bitirme.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface IJwtProvider {

    String generateToken(UserPrincipal auth);
    Authentication getAuthentication(HttpServletRequest request);
    boolean validateTime(HttpServletRequest request);
}
