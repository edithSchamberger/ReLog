package ar.edu.undef.fie.api.Relog.service.impl;

import ar.edu.undef.fie.api.Relog.repository.EfectoRepository;
import ar.edu.undef.fie.api.Relog.repository.EstadoAbastecimientoRepository;
import ar.edu.undef.fie.api.Relog.repository.MovimientoRepository;
import ar.edu.undef.fie.api.Relog.model.entity.Efecto;
import ar.edu.undef.fie.api.Relog.model.entity.EstadoAbastecimiento;
import ar.edu.undef.fie.api.Relog.model.entity.movimiento.Movimiento;
import ar.edu.undef.fie.api.Relog.model.entity.movimiento.MovimientoPersistent;
import ar.edu.undef.fie.api.Relog.model.entity.movimiento.impl.Egreso;
import ar.edu.undef.fie.api.Relog.model.entity.movimiento.impl.Ingreso;
import ar.edu.undef.fie.api.Relog.model.request.MovimientoRequest;
import ar.edu.undef.fie.api.Relog.model.response.MovimientoResponse;
import ar.edu.undef.fie.api.Relog.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    EstadoAbastecimientoRepository estadoAbastecimientoRepository;

    @Autowired
    EfectoRepository efectoRepository;

    @Autowired
    MovimientoRepository movimientoRepository;

    @Override
    public MovimientoResponse generarMovimiento(MovimientoRequest request, Long tipo) {
        var estado = this.getEstadoFromRequest(request);
        var movimiento = this.getMovimientoFromRequest(request, tipo);
        var efecto = this.getEfecto(estado, movimiento);
        this.validarEstado(estado, efecto);
        this.addMovimiento(request, tipo, estado);
        return this.getBuildMovimientoResponse(request, tipo, estado, efecto);
    }

    private EstadoAbastecimiento getEstadoFromRequest(MovimientoRequest request) {
        return Optional.of(estadoAbastecimientoRepository.findAByAbastecimientoId(
                        request.getAbastecimientoId())).get();
    }

    private void addMovimiento(MovimientoRequest request, Long tipo, EstadoAbastecimiento estado) {
        estado.getMovimientoIds().add(getBuildMovimientoPersistent(request, tipo, estado));
        estado.setOrganizacionId(request.getOrganizacionId());
        estadoAbastecimientoRepository.save(estado);
    }

    private MovimientoPersistent getBuildMovimientoPersistent(MovimientoRequest request, Long tipo, EstadoAbastecimiento estado) {
        return MovimientoPersistent.builder()
                .descripcion(this.getStringMovimiento(tipo))
                .tipo(tipo)
                .cantidad(request.getCantidad())
                .organizacionId(request.getOrganizacionId())
                .abastecimientoId(request.getAbastecimientoId())
                .build();
    }

    private String getStringMovimiento(Long tipo) {
        String tipoMovimiento = null;
        if(tipo == 1L) tipoMovimiento = "ingreso";
        if(tipo == 2L) tipoMovimiento = "egreso";
        return tipoMovimiento;
    }

    private MovimientoResponse getBuildMovimientoResponse(
            MovimientoRequest request, Long tipo, EstadoAbastecimiento estado, Efecto efecto) {
        return MovimientoResponse.builder()
                .tipo(tipo)
                .cantidadActual(efecto.getCantidad())
                .estadoAbastecimientoActual(estado.getEstadoId())
                .descripcion(this.getStringMovimiento(tipo))
                .build();
    }

    private Efecto getEfecto(EstadoAbastecimiento estado, Movimiento movimiento) {
        Efecto efecto = estado.getEfecto();
        this.setCantidadEfecto(movimiento, efecto);
        return efecto;
    }

    private void setCantidadEfecto(Movimiento movimiento, Efecto efecto) {
        efecto.setCantidad(movimiento.realizarMovimiento(efecto.getCantidad()));
    }

    private Movimiento getMovimientoFromRequest(MovimientoRequest request, Long tipo) {
        if(tipo == 1L) return new Ingreso(request.getCantidad(),"ingreso");
        if(tipo == 2L) return new Egreso(request.getCantidad(),"egreso");
            return null;
    }

    private void validarEstado(EstadoAbastecimiento estado, Efecto efecto) {
        if (estado.getEstadoId()!= 2L && efecto.getCantidad() < estado.getCantidadNecesaria()) estado.setEstadoId(2L);
        if (estado.getEstadoId()!= 1L && efecto.getCantidad() >= estado.getCantidadNecesaria()) estado.setEstadoId(1L);
        this.saveEfecto(efecto);
    }

    private void saveEfecto(Efecto efecto) {
        efectoRepository.save(efecto);
    }

}
