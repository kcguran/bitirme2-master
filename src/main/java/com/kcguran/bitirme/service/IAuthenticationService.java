package com.kcguran.bitirme.service;

import com.kcguran.bitirme.model.Kullanicilar;

public interface IAuthenticationService {

    Kullanicilar signInAndReturnJWT(Kullanicilar signInRequest);
}
