package com.kcguran.bitirme.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "urunler")
public class Urunler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "urunadi")
    private String urunadi;
    @Column(name = "urunfiyati")
    private String urunfiyati;
    @Column(name = "urunsaticilari")
    private String urunsaticilari;
}
