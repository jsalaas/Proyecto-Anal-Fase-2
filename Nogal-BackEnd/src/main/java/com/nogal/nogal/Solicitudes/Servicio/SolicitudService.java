package com.nogal.nogal.Solicitudes.Servicio;

import java.util.List;

import com.nogal.nogal.Solicitudes.Modelos.Solicitud;
import com.nogal.nogal.Solicitudes.Repositorio.SolicitudRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Service;

@Service
public class SolicitudService{
    @Autowired
    SolicitudRepo repositorio;

    public boolean crear(Solicitud sol){
        try{
            repositorio.save(sol);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public boolean actualizar(Solicitud sol){
        try{
            repositorio.save(sol);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public List<Solicitud> obtenerAllId(long id){
        return repositorio.findByTecnicoOrCliente(id, id);
    }
}