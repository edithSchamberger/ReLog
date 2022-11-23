package ar.edu.undef.fie.api.Relog.model.entity.estado.impl;


import ar.edu.undef.fie.api.Relog.model.entity.estado.Estado;
import ar.edu.undef.fie.api.Relog.model.entity.EstadoAbastecimiento;

public class ConStock implements Estado {

    final String CON_STOCK = "con stock";

    @Override
    public void imprimir(EstadoAbastecimiento context) {
        System.out.println("Estado: " + CON_STOCK);
    }

    @Override
    public String getEstado() {return CON_STOCK;}
}
