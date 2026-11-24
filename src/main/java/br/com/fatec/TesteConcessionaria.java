package br.com.fatec;

public class TesteConcessionaria {
    public static void main(String[] args) {
        Concessionaria c = new Concessionaria();
        System.out.println("Carros no estoque: " + c.restantes());
        for (int i = 0; i < 3; i++) {
            System.out.println("Sorteou: " + c.sortear());
        }
        System.out.println("Carros no estoque: " + c.restantes());
    }
}
