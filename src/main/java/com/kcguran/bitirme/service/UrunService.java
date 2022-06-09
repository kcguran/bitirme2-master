package com.kcguran.bitirme.service;

import com.kcguran.bitirme.model.Urunler;
import com.kcguran.bitirme.repository.UrunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrunService implements IUrunService{

    @Autowired
    private UrunRepository urunRepository;

    @Override
    public Urunler saveUrunler(Urunler urunler) {
        return urunRepository.save(urunler);
    }

    @Override
    public void deleteUrunler(Long id) {
        urunRepository.deleteById(id);
    }

    @Override
    public List<Urunler> findAllUrunler() {
        return urunRepository.findAll();
    }
}
