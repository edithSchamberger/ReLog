package ar.edu.undef.fie.api.Relog.model.entity.movimiento;


public interface Movimiento {

    Long realizarMovimiento(Long cantidadEfecto);

    void imprimirMovimiento();
}
