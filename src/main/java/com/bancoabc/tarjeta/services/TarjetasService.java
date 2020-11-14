package com.bancoabc.tarjeta.services;

import com.bancoabc.tarjeta.dto.PersonaDto;
import com.bancoabc.tarjeta.dto.TarjetaDto;
import com.bancoabc.tarjeta.entity.Persona;
import com.bancoabc.tarjeta.entity.Tarjeta;
import com.bancoabc.tarjeta.repository.PersonaRepository;
import com.bancoabc.tarjeta.repository.TarjetaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarjetasService implements ITarjetasService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<TarjetaDto> getTarjetas() {
        return tarjetaRepository.findAll()
                .stream()
                .map(entity -> {
                            PersonaDto personaDto = new PersonaDto();
                            BeanUtils.copyProperties(entity.getPersona(), personaDto);
                            return new TarjetaDto(
                                    entity.getId(),
                                    entity.getNombre(),
                                    entity.getFecha(),
                                    entity.getCodigo(),
                                    personaDto
                            );
                        }

                ).collect(Collectors.toList());
    }

    @Override
    public TarjetaDto addtarjeta(TarjetaDto t) {
        Tarjeta nuevaTarjeta = tarjetaRepository.findById(t.getId() == null ? -1 : t.getId()).orElse(new Tarjeta());
        nuevaTarjeta.setNombre(t.getNombre());
        nuevaTarjeta.setFecha(t.getFecha());
        nuevaTarjeta.setCodigo(t.getCodigo());
        Persona persona = personaRepository.findById(t.getPersona().getId()).get();
        nuevaTarjeta.setPersona(persona);
        tarjetaRepository.save(nuevaTarjeta);
        return t;
    }
}
