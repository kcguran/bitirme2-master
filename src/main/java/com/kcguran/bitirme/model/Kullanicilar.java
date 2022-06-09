package com.kcguran.bitirme.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "kullanicilar")
public class Kullanicilar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kullaniciadi", unique = true, nullable = false, length = 100)
    private String kullaniciadi;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "isim", nullable = false, length = 100)
    private String isim;

    @Column(name = "createtime", nullable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Transient
    private String token;
}
