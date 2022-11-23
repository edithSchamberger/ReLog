package ar.edu.undef.fie.api.Relog.model.entity.clase;

import lombok.Data;

@Data
public class Vestuario extends Clase {

    @Override
    public void imprimir() {
        System.out.println("Clase tipo vestuario");
    }

}
