package com.bancoabc.tarjeta.services;


import com.bancoabc.tarjeta.dto.PersonaDto;
import com.bancoabc.tarjeta.dto.TarjetaDto;

import java.util.List;

public interface ITarjetasService {

    List<TarjetaDto> getTarjetas();

    TarjetaDto addtarjeta(TarjetaDto Nuevatarjeta);

}