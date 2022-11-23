package ar.edu.undef.fie.api.Relog.model.entity.estado.impl;


import ar.edu.undef.fie.api.Relog.model.entity.estado.Estado;
import ar.edu.undef.fie.api.Relog.model.entity.EstadoAbastecimiento;

public class ConFaltantes implements Estado {

    final String CON_FALTANTES = "con faltantes";

    @Override
    public void imprimir(EstadoAbastecimiento context) {
        System.out.println("Estado: " + CON_FALTANTES);
    }

    @Override
    public String getEstado() {return CON_FALTANTES;}
}
