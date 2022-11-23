package ar.edu.undef.fie.api.Relog.model.entity.estado;

import ar.edu.undef.fie.api.Relog.model.entity.EstadoAbastecimiento;

public interface Estado {

    void imprimir(EstadoAbastecimiento context);

    String getEstado();
}
