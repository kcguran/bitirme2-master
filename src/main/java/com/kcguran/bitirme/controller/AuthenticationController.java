package com.kcguran.bitirme.controller;

import com.kcguran.bitirme.model.Kullanicilar;
import com.kcguran.bitirme.service.AuthenticationService;
import com.kcguran.bitirme.service.KullanicilarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private KullanicilarService kullanicilarService;

    @PostMapping("kayit-ol")
    public ResponseEntity<?> kayitOl(@RequestBody Kullanicilar kullanicilar){
        if (kullanicilarService.findByUsername(kullanicilar.getKullaniciadi()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(kullanicilarService.saveKullanicilar(kullanicilar),HttpStatus.CREATED);
    }

    @PostMapping("giris-yap")
    public ResponseEntity<?> girisYap(@RequestBody Kullanicilar kullanicilar){
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(kullanicilar), HttpStatus.OK);
    }
}
