package com.bancoabc.tarjeta.security.repository;

import com.bancoabc.tarjeta.security.entity.Rol;
import com.bancoabc.tarjeta.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}