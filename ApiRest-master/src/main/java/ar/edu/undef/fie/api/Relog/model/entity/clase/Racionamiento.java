package ar.edu.undef.fie.api.Relog.model.entity.clase;

import lombok.Data;

@Data
public class Racionamiento extends Clase {

    private String especificidad;

    @Override
    public void imprimir() {
        System.out.println("Clase tipo racionamiento");
    }

}
