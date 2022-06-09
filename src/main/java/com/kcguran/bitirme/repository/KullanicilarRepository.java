package com.kcguran.bitirme.repository;

import com.kcguran.bitirme.model.Kullanicilar;
import com.kcguran.bitirme.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KullanicilarRepository extends JpaRepository<Kullanicilar,Long> {
    Optional<Kullanicilar> findByKullaniciadi(String kullaniciadi);

    @Modifying
    @Query("update Kullanicilar set role =:role where kullaniciadi = :kullaniciadi")
    void updateUserRole(@Param("kullaniciadi")String kullaniciadi,@Param("role") Role role);
}
