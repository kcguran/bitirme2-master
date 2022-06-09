package com.kcguran.bitirme.service;

import com.kcguran.bitirme.model.Urunler;

import java.util.List;

public interface IUrunService {

    Urunler saveUrunler(Urunler urunler);
    void deleteUrunler(Long id);
    List<Urunler> findAllUrunler();
}
