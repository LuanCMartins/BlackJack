/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IAs;

import B_Pilha.*;
import A_Baralho.*;
import C_Fila.Queue;
import java.util.ArrayList;

/**
 *
 * 
 * @author LuanC
 */
public class Dealer {

    private final Pilha<Carta> baralho;

    public Dealer() {
        baralho = new Pilha<>();
        Baralho deck = new Baralho();
        deck.embaralhar();
        ArrayList<Carta> bar = deck.getBaralho();

        while (!bar.isEmpty()) {
            baralho.push(deck.retiraCarta());
        }
    }

    public Pilha getBaralho() {
        return baralho;
    }

    public Carta entregaCarta() {
        return baralho.pop();
    }

    //checa se o jogador apssado como parâmetrod eseja receber cartas
    public boolean pergunta(Jogador x) {
        return x.logicaDeCartas();
    }

    //Metodo que executa a primeira rodada
    public Carta startGame(Queue<Jogador> jogadores, Pilha<Carta> mesa) {

        for (Jogador jogadorIdx : jogadores.toArray()) {
            while (jogadorIdx.getTotalCartasJogador() < 2) {
                jogadorIdx.carta(this.entregaCarta());
            }
        }
        
        Carta prim = this.entregaCarta();
            mesa.push(prim);
            this.entregaCartaDaMesa(jogadores, prim);

            Carta cartaVirada = this.entregaCarta();
            mesa.push(new Carta("?", "?"));
        return cartaVirada;
    }

    //Metodo que entrega as cartas que estão na mesa, para o jogador
    public boolean entregaCartaDaMesa(Queue<Jogador> players, Carta x) {
        if (players.isEmpty()) {
            return false;
        } else {
            for (Jogador jogadorIdx : players.toArray()) {
                if (this.pergunta(jogadorIdx)) {
                    jogadorIdx.carta(x);
                }
            }
            return true;
        }
    }

    //Encontra o primeiro jogador que ainda deseja receber cartas que está na fila
    public Jogador primeiroValido(Queue<Jogador> players) {
        if (!players.isEmpty()) {
            Jogador primeiro = players.peek();
            while (!this.pergunta(primeiro) && !players.isEmpty()) {
                System.out.println(Jogo.jogoEncerrado(players));
                if (!players.isEmpty()) {
                    primeiro = players.peek();
                }
            }
            return primeiro;
        } else {
            return null;
        }
    }
}
