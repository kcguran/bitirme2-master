package com.kcguran.bitirme.security;

import com.kcguran.bitirme.model.Kullanicilar;
import com.kcguran.bitirme.service.IKullanicilarService;
import com.kcguran.bitirme.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IKullanicilarService kullanicilarService;
    @Override
    public UserDetails loadUserByUsername(String kullaniciadi) throws UsernameNotFoundException {
        Kullanicilar kullanicilar = kullanicilarService.findByUsername(kullaniciadi)
                .orElseThrow(() ->new UsernameNotFoundException(kullaniciadi));

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(kullanicilar.getRole().name()));

        return UserPrincipal.builder()
                .kullanicilar(kullanicilar).id(kullanicilar.getId())
                .kullaniciadi(kullaniciadi)
                .password(kullanicilar.getPassword())
                .authorities(authorities)
                .build();
    }
}
