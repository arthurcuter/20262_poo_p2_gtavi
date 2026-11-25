package br.com.fatec;

import lombok.Builder;
import lombok.Getter;

@Getter 
@Builder 
public class Partida {
    private int codigo;
    private String jogador;
    private int pontuacao;
}
