package com.kcguran.bitirme.controller;

import com.kcguran.bitirme.model.Gecmis;
import com.kcguran.bitirme.security.UserPrincipal;
import com.kcguran.bitirme.service.GecmisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/gecmis")
public class GecmisController {

    @Autowired
    private GecmisService gecmisService;

    @PostMapping
    public ResponseEntity<?> saveGecmis(@RequestBody Gecmis gecmis){
        return new ResponseEntity<>(gecmisService.saveGecmis(gecmis), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(gecmisService.findGecmisKullaniciyaGore(userPrincipal.getId()));
    }
}
