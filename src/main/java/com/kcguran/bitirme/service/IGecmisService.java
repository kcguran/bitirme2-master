package com.kcguran.bitirme.service;

import com.kcguran.bitirme.model.Gecmis;
import com.kcguran.bitirme.repository.projection.AlinanUrun;

import java.util.List;

public interface IGecmisService {

    Gecmis saveGecmis(Gecmis gecmis);
    List<AlinanUrun> findGecmisKullaniciyaGore(Long kullaniciid);
}
