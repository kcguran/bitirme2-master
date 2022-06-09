package com.kcguran.bitirme.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "gecmis")
public class Gecmis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "kullaniciid", nullable = false)
    private Long kullaniciid;

    @Column(name = "urunid", nullable = false)
    private Long urunid;

    @Column(name = "ucret", nullable = false)
    private Double ucret;

    @Column(name = "gecmistarih", nullable = false)
    private LocalDateTime gecmistarih;
}
