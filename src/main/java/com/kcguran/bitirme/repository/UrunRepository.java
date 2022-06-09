package com.kcguran.bitirme.repository;

import com.kcguran.bitirme.model.Urunler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrunRepository extends JpaRepository<Urunler,Long> {
}
