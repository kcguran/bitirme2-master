package com.kcguran.bitirme.service;

import com.kcguran.bitirme.model.Kullanicilar;

import java.util.Optional;

public interface IKullanicilarService {

    Kullanicilar saveKullanicilar(Kullanicilar kullanicilar);
    Optional<Kullanicilar> findByUsername(String kullaniciadi);
    void makeAdmin(String kullaniciadi);
}
