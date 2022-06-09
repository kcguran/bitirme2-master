package com.kcguran.bitirme.service;

import com.kcguran.bitirme.model.Gecmis;
import com.kcguran.bitirme.repository.GecmisRepository;
import com.kcguran.bitirme.repository.projection.AlinanUrun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GecmisService implements IGecmisService {

    @Autowired
    private GecmisRepository gecmisRepository;

    @Override
    public Gecmis saveGecmis(Gecmis gecmis) {
        gecmis.setGecmistarih(LocalDateTime.now());
        return gecmisRepository.save(gecmis);
    }

    @Override
    public List<AlinanUrun> findGecmisKullaniciyaGore(Long kullaniciid) {
        return gecmisRepository.findAllPurchasesOfUser(kullaniciid);
    }
}
