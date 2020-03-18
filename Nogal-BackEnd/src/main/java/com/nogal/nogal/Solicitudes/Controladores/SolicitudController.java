package com.nogal.nogal.Solicitudes.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.nogal.nogal.Autentificacion.util.JwtUtil;
import com.nogal.nogal.Solicitudes.Modelos.Solicitud;
import com.nogal.nogal.Solicitudes.Servicio.SolicitudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class SolicitudController{
    @Autowired
    SolicitudService servicio;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/crearsolicitud")
    public boolean crear(@RequestHeader("Authorization") @RequestBody @Valid Solicitud solicitud){
        return servicio.crear(solicitud);
    }

    @GetMapping("/solicitudes")
    public List<Solicitud> obtenerId(@RequestHeader("Authorization") String jwt){
        // extraigo el usuario
        jwt = jwt.substring(7);
        final long id = jwtUtil.extractId(jwt);

        return servicio.obtenerAllId(id);
    }
}