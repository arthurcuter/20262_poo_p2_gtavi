package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

public class TesteCampeonato {
    public static void main(String[] args) {
        Concessionaria concessionaria = new Concessionaria();
        Campeonato campeonato = new Campeonato();

        Piloto lucia = new Piloto("Lucia", concessionaria.sortear());
        Piloto jason = new Piloto("Jason", concessionaria.sortear());
        Piloto raul = new Piloto("Raul", concessionaria.sortear());
        Piloto cal = new Piloto("Cal", concessionaria.sortear());

        campeonato.inscrever(lucia);
        campeonato.inscrever(jason);
        campeonato.inscrever(new Piloto("Lucia", concessionaria.sortear()));
        campeonato.inscrever(raul);
        campeonato.inscrever(cal);
        campeonato.inscrever(new Piloto("Boobie", concessionaria.sortear()));

        List<Piloto> lista1 = new ArrayList<>();
        lista1.add(lucia);
        lista1.add(jason);
        lista1.add(raul);
        lista1.add(cal);
        campeonato.registrarCorrida(lista1);
        
        List<Piloto> lista2 = new ArrayList<>();
        lista2.add(raul);
        lista2.add(cal);
        lista2.add(jason);
        lista2.add(lucia);
        campeonato.registrarCorrida(lista2);

        List<Piloto> lista3 = new ArrayList<>();
        lista3.add(cal);
        lista3.add(raul);
        lista3.add(jason);
        lista3.add(lucia);
        campeonato.registrarCorrida(lista3);
        
        int i = 1;
        for(Piloto p : campeonato.getClassificacao()) {
            System.out.println(i + ". " + p.toString());
            i++;
        }

    }
}
