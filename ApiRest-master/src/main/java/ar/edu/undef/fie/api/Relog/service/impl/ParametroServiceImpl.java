package ar.edu.undef.fie.api.Relog.service.impl;

import ar.edu.undef.fie.api.Relog.model.entity.inicio.Parametro;
import ar.edu.undef.fie.api.Relog.model.entity.inicio.Usuario;
import ar.edu.undef.fie.api.Relog.repository.ParametroRepository;
import ar.edu.undef.fie.api.Relog.service.ParametroService;
import org.springframework.stereotype.Service;

@Service
public class ParametroServiceImpl implements ParametroService {

    private final ParametroRepository parametroRepository;

    public ParametroServiceImpl(ParametroRepository parametroRepository) {
        this.parametroRepository = parametroRepository;
    }

    @Override
    public Parametro getParametros(Long idUser) {
        return parametroRepository.findByUsuarioId(idUser);
    }

    @Override
    public Parametro modificarParametros(Parametro parametro) {
        return parametroRepository.save(parametro);
    }

    @Override
    public void crearParametros(Usuario usuario) {
        Parametro nuevosParametros = new Parametro();
        nuevosParametros.setUsuario(usuario);
        nuevosParametros.setGan_por_op(0.1);
        nuevosParametros.setPer_por_op(0.05);
        nuevosParametros.setVariacion_entr_caidas(0.1);
        parametroRepository.save(nuevosParametros);
    }
}
