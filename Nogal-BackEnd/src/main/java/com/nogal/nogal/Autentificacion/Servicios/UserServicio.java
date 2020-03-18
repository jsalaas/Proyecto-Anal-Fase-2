package com.nogal.nogal.Autentificacion.Servicios;

import java.util.Optional;

import com.nogal.nogal.Autentificacion.Modelos.User;
import com.nogal.nogal.Autentificacion.Repositorios.UserRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicio{

    @Autowired
    UserRepositorio repositorio;

    public User obtenerNombre(String nombre){
        Optional<User> user = repositorio.findByUserName(nombre);

        user.orElse(null);
        return user.get();
    }


}