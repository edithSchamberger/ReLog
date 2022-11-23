package ar.edu.undef.fie.api.Relog.model.entity.movimiento.impl;

import ar.edu.undef.fie.api.Relog.model.entity.movimiento.Movimiento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Egreso implements Movimiento {


    private Long cantidad;

    private String descripcion;


    @Override
    public Long realizarMovimiento(Long cantidadEfecto) {
        return cantidadEfecto - (Long) cantidad;
    }

    @Override
    public void imprimirMovimiento() {
        System.out.println("Movimiento: " + descripcion + ", Cantidad: " + cantidad);
    }
}
