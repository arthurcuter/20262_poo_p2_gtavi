package br.com.fatec;

import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class Jogo {
    private static final int CORRIDAS = 3;
    private static final int NITROS = 2;

    public static void main(String[] args) {
        var menu = "1-Jogar\n2-Ranking\n0-Sair";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (op) {
                case 1:
                    jogarCampeonato();
                    break;
                case 2:
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Ate a proxima!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida");
                    break;
            }

        } while (op != 0);
    }

    public static void jogarCampeonato() {
        String nome = JOptionPane.showInputDialog("Qual seu nome?");
        int op = 0;
        String nomePiloto = null;
        Piloto piloto;
        Concessionaria concessionaria = new Concessionaria();
        Campeonato campeonato = new Campeonato();
        while(!(op == 1 || op == 2)) {
            op = Integer.parseInt(JOptionPane.showInputDialog("Escolha um piloto:\n1-Jason\n2-Lucia"));
            
            switch (op) {
                case 1:
                    nomePiloto = "Jason";
                    break;
                case 2:
                    nomePiloto = "Lucia";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida");
                    break;
            }
        }

        piloto = new Piloto(nomePiloto, concessionaria.sortear());
        Piloto raul = new Piloto("Raul", concessionaria.sortear());
        Piloto boobie = new Piloto("Boobie", concessionaria.sortear());
        Piloto cal = new Piloto("Cal", concessionaria.sortear());
        campeonato.inscrever(piloto);
        campeonato.inscrever(raul);
        campeonato.inscrever(boobie);
        campeonato.inscrever(cal);
        JOptionPane.showMessageDialog(null, "Seu carro: " + piloto.getCarro());

        int corridas = 1;
        int nitros = NITROS;
        Random random = new Random();
        while(corridas <= CORRIDAS) {
            int nitroOp = Integer.parseInt(JOptionPane.showInputDialog("Corrida " + corridas + "/" + CORRIDAS + "\n" + montaClassificacao(campeonato.getClassificacao()) + "\nUsar nitro? 1-Sim 2-Nao (restam " + nitros + ")"));
            boolean nitro = false;

            if(nitroOp == 1 && nitros <= 0) {
                JOptionPane.showMessageDialog(null, "Sem nitro restante");
            }else if (nitroOp == 1 && nitros > 0) {
                nitro = true;
                nitros--;
            } else {
                nitro = false;
            }
            List<Piloto> chegada = campeonato.disputarCorrida(random, piloto, nitro);
            int i = 1;
            StringBuilder sb = new StringBuilder();
            for(Piloto p : chegada) {
                sb.append(i + ". " + p.getNome() + " - " + p.getTempo() + "s\n");
                i++;
            }
            JOptionPane.showMessageDialog(null, "Chegada\n" + sb);
            corridas++;
        }
        int posicao = 0;
        int i = 1;
        for(Piloto p : campeonato.getClassificacao()) {
            if(p.equals(piloto)) posicao = i;
            i++;
        }
        String mensagem = posicao == 1 ? "Campeao de Vice City!" : "Posicao final: " + posicao;
        JOptionPane.showMessageDialog(null, montaClassificacao(campeonato.getClassificacao()) + "\n" + mensagem);

        Partida partida = Partida.builder().jogador(nome).pontuacao(piloto.getPontos()).build();
        if(PartidaDAO.cadastrar(partida)) {
            JOptionPane.showMessageDialog(null, "Partida salva");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar a partida");
        }


    }

    public static String montaClassificacao (List<Piloto> pilotos) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for(Piloto p : pilotos) {
            sb.append(i + ". " + p + "\n");
            i++;
        }
        return sb.toString();
    }

}
