package com.kcguran.bitirme.repository.projection;

import java.time.LocalDateTime;

public interface AlinanUrun{

    String getIsim();
    Double getUcret();
    LocalDateTime getGecmisTarih();

}
