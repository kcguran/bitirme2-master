package com.kcguran.bitirme.service;

import com.kcguran.bitirme.model.Kullanicilar;
import com.kcguran.bitirme.security.UserPrincipal;
import com.kcguran.bitirme.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;



    @Override
    public Kullanicilar signInAndReturnJWT(Kullanicilar signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getKullaniciadi(),signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);
        Kullanicilar signInUser = userPrincipal.getKullanicilar();
        signInUser.setToken(jwt);
        return  signInUser;
    }
}
