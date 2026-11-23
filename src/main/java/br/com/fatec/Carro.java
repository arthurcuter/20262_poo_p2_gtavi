package br.com.fatec;

import lombok.*;

@Getter
@AllArgsConstructor

public class Carro {
    private String modelo;
    private int potencia;

    public int getTempoDeVolta() {
        return 30 + 6000 / potencia;
    }

    @Override
    public String toString() {
        return String.format("%s (%d cv)", modelo, potencia);
    }
}
