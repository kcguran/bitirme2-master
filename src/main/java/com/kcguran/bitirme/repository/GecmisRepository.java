package com.kcguran.bitirme.repository;

import com.kcguran.bitirme.model.Gecmis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.kcguran.bitirme.repository.projection.AlinanUrun;
import org.springframework.stereotype.Repository;

@Repository
public interface GecmisRepository extends JpaRepository<Gecmis,Long>{
    @Query("select b.urunadi as urunadi, ph.ucret as ucret, ph.gecmistarih as gecmistarih from Gecmis ph left join  Urunler b on b.id = ph.urunid where ph.kullaniciid = kullaniciid")
    List<AlinanUrun> findAllPurchasesOfUser(@Param("kullaniciid")Long kullaniciid);
}