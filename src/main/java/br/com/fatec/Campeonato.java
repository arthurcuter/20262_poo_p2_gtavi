package br.com.fatec;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Campeonato {
    private static final int[] PONTOS = {10, 6, 3, 1};

    private List<Piloto> pilotos = new ArrayList<>();

    public void inscrever(Piloto piloto) {
        if (pilotos.size() >= 4) {
            System.out.println("Grid cheio.");
        } else {
            for (Piloto p : pilotos) {
                if (p.equals(piloto)) {
                    System.out.println("Piloto repetido.");
                    return;
                }
            }
            pilotos.add(piloto);
        }
    }

    public void registrarCorrida(List<Piloto> chegada) {
        for (int i = 0; i < chegada.size(); i++) {
            chegada.get(i).somarPontos(PONTOS[i]);
        }
        chegada.get(0).registrarVitoria();
    }

    public List<Piloto> disputarCorrida(Random gerador, Piloto jogador, boolean nitro) {
        List<Piloto> chegada = new ArrayList<>();
        for (Piloto p : pilotos) {
            p.correr(gerador, p.equals(jogador) && nitro);
            chegada.add(p);
        }
        chegada.sort(new Comparator<Piloto>() {
            @Override
            public int compare(Piloto p1, Piloto p2) {
                if(p1.getTempo() < p2.getTempo()) return -1;
                if(p1.getTempo() > p2.getTempo()) return 1;
                return 0;
            }
        });
        registrarCorrida(chegada);
        return chegada;
    }

    public List<Piloto> getClassificacao() {
        List<Piloto> classificacao = new ArrayList<>();
        for (Piloto p : pilotos) {
            classificacao.add(p);
        }
        classificacao.sort(new Comparator<Piloto>() {
            @Override 
            public int compare(Piloto p1, Piloto p2) {
                if(p1.getPontos() > p2.getPontos()) return -1;
                if(p1.getPontos() == p2.getPontos()) {
                    if(p1.getVitorias() > p2.getVitorias()) {
                        return -1;
                    } else if (p1.getVitorias() < p2.getVitorias()) {
                        return 1;
                    }
                    return p1.getNome().compareTo(p2.getNome());

                } else {
                    return 1;
                }
                
            }
        });
        return classificacao;
    }

}