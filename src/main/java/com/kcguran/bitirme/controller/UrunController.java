package com.kcguran.bitirme.controller;

import com.kcguran.bitirme.model.Urunler;
import com.kcguran.bitirme.service.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/urunler")
public class UrunController {

    @Autowired
    private UrunService urunService;


    @PostMapping
    public ResponseEntity<?> saveUrun(@RequestBody Urunler urunler){
        return new ResponseEntity<>(urunService.saveUrunler(urunler), HttpStatus.CREATED);
    }

    @DeleteMapping("{urunid}")
    public ResponseEntity<?> deleteUrun(@PathVariable Long urunid){
        urunService.deleteUrunler(urunid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllUrunler(){
        System.out.println(urunService.findAllUrunler());
        return new ResponseEntity<>(urunService.findAllUrunler(),HttpStatus.OK);

    }
}
