package com.bancoabc.tarjeta.controller;


import com.bancoabc.tarjeta.dto.PersonaDto;
import com.bancoabc.tarjeta.dto.TarjetaDto;
import com.bancoabc.tarjeta.repository.TarjetaRepository;
import com.bancoabc.tarjeta.services.ITarjetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class TarjetasController {
    @Autowired
    private ITarjetasService TarjetasService;


    @GetMapping(value = "/tarjeta")
    public List<TarjetaDto> getTarjetas() {
        return TarjetasService.getTarjetas();
    }

    @PostMapping(value = "/tarjeta")
    public TarjetaDto getTarjetas(@RequestBody TarjetaDto tarjeta) {
        return TarjetasService.addtarjeta(tarjeta);
    }
}
