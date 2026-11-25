package br.com.fatec;

import java.util.List;

public class TestePartidaDAO {
    public static void main(String[] args) {
        Partida p1 = Partida.builder().jogador("Ana").pontuacao(26).build();
        Partida p2 = Partida.builder().jogador("Bia").pontuacao(13).build();
        boolean deuCertoP1 = PartidaDAO.cadastrar(p1);
        boolean deuCertoP2 = PartidaDAO.cadastrar(p2);

        System.out.printf("Cadastrou %s? %s\n", p1.getJogador(), deuCertoP1);
        System.out.printf("Cadastrou %s? %s\n", p2.getJogador(), deuCertoP2);
        List<Partida> lista = PartidaDAO.listar();
        for (Partida partida : lista) {
            System.out.println(partida.getCodigo() + " - " + partida.getJogador() + " - " + partida.getPontuacao());
        }
    }
}
