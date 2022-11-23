package ar.edu.undef.fie.api.Relog.service.impl;

import ar.edu.undef.fie.api.Relog.model.entity.inicio.Usuario;
import ar.edu.undef.fie.api.Relog.model.entity.inicio.Sesion;
import ar.edu.undef.fie.api.Relog.repository.SesionRepository;
import ar.edu.undef.fie.api.Relog.service.SesionService;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class SesionServiceImpl implements SesionService {

    private final SesionRepository sesionRepository;

    public SesionServiceImpl(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }


    @Override
    public Sesion getSesionActiva() {
        return sesionRepository.findSesionByActiva(true);
    }

    @Override
    public void nuevaSesion(Usuario usuario) {
        cerrarSesion();
        Sesion sesionNueva = new Sesion();
        sesionNueva.setUsuario(usuario);
        sesionNueva.setInicioSesion(Calendar.getInstance());
        sesionNueva.setActiva(true);
        sesionRepository.save(sesionNueva);

    }

    @Override
    public void cerrarSesion() {
        Sesion sesionActiva = getSesionActiva();
        if (sesionActiva != null){
            sesionActiva.setActiva(false);
            sesionActiva.setFinSesion(Calendar.getInstance());
            sesionRepository.save(sesionActiva);
        }

    }
}

