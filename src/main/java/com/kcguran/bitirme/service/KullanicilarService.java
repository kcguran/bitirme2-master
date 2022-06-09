package com.kcguran.bitirme.service;

import com.kcguran.bitirme.model.Kullanicilar;
import com.kcguran.bitirme.model.Role;
import com.kcguran.bitirme.repository.KullanicilarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class KullanicilarService implements IKullanicilarService{

    @Autowired
    private KullanicilarRepository kullanicilarRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Kullanicilar saveKullanicilar(Kullanicilar kullanicilar) {
        kullanicilar.setPassword(passwordEncoder.encode(kullanicilar.getPassword()));
        kullanicilar.setRole(Role.ADMIN);
        kullanicilar.setCreateTime(LocalDateTime.now());
        return kullanicilarRepository.save(kullanicilar);
    }

    @Override
    public Optional<Kullanicilar> findByUsername(String kullaniciadi) {
        return kullanicilarRepository.findByKullaniciadi(kullaniciadi);
    }

    @Override
    @Transactional
    public void makeAdmin(String kullaniciadi) {
        kullanicilarRepository.updateUserRole(kullaniciadi,Role.ADMIN);

    }
}
