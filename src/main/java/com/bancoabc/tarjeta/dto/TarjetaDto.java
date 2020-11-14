package com.bancoabc.tarjeta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TarjetaDto {
    private Long id;
    private String nombre;
    private String fecha;
    private Long codigo;
    private PersonaDto persona;

}
