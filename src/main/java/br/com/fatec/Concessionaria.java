package br.com.fatec;

import java.util. *;

public class Concessionaria {
    private List<Carro> estoque;
    private Random gerador;

    public Concessionaria() {
        this.estoque = new ArrayList<>();
        this.gerador = new Random();

        String[] modelos = {
            "Truffade Adder",
            "Grotti Cheetah",
            "Pegassi Infernus",
            "Vapid Dominator",
            "Bravado Banshee",
            "Declasse Vigero",
            "Karin Sultan",
            "Dinka Blista"
        };
        int[] potencias = {520, 500, 480, 420, 400, 350, 300, 200};

        for (int i = 0; i < modelos.length; i++) {
            this.estoque.add(new Carro(modelos[i], potencias[i]));
        }
    }

    public Carro sortear() {
        int posicao = this.gerador.nextInt(this.estoque.size());
        Carro sorteado = this.estoque.get(posicao);
        this.estoque.remove(posicao);
        return sorteado;
    }

    public int restantes() {
        return this.estoque.size();
    }
}
