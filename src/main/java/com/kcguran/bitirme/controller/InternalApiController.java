package com.kcguran.bitirme.controller;

import com.kcguran.bitirme.service.KullanicilarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/internal")
public class InternalApiController {

    @Autowired
    private KullanicilarService kullanicilarService;

    @PutMapping("make-admin/{kullaniciadi}")
    public ResponseEntity<?> makeAdmin(@PathVariable String kullaniciadi){
        kullanicilarService.makeAdmin(kullaniciadi);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
