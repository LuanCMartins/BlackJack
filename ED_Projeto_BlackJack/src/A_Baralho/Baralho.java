package A_Baralho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Baralho {

    private final String[] nomeCarta = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Dama", "Valete", "Rei"};
    private final String[] naipeCarta = {"Paus", "Copas", "Espadas", "Ouros"};

    private final ArrayList<Carta> baralho = new ArrayList<>();

    public ArrayList<Carta> getBaralho() {
        return baralho;
    }

    public Baralho() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 12; j++) {
                Carta c1 = new Carta(nomeCarta[j], naipeCarta[i]);
                baralho.add(c1);
            }
        }
    }

    public boolean embaralhar() {
        ArrayList<Carta> baralhoEm = new ArrayList<>();
        Random rnd = new Random();

        while (baralho.size() > 1) {
            int posRand = rnd.nextInt(baralho.size());
            baralhoEm.add(baralho.get(posRand));
            baralho.remove(posRand);
        }
        baralhoEm.add(baralho.get(0));
        baralho.clear();

        while (!baralhoEm.isEmpty()) {
            int i = 0;
            baralho.add(baralhoEm.get(i));
            baralhoEm.remove(i);
        }
        return true;
    }

    public Carta retiraCarta() {

        Random rnd = new Random();

        int carta = rnd.nextInt(baralho.size());
        return baralho.remove(carta);//Remove a carta retirada do baralho
    }

    public String imprimeBaralho() {
        String saida = "";
        for (Carta baralho1 : baralho) {
            saida += baralho1.toString() + "\n";
        }
        return saida;
    }

    @Override
    public String toString() {
        return "Baralho: \n" + imprimeBaralho();
    }

}
