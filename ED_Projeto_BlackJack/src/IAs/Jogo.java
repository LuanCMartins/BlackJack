/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IAs;

import A_Baralho.Carta;
import B_Pilha.*;
import C_Fila.Queue;

/**
 *
 * @author LuanC
 */
public class Jogo {

    private final Dealer dealer;
    private final Jogador jogador1/*, jogador2, jogador3, jogador4*/;
    private final Pilha<Carta> mesa;
    private final Queue<Jogador> players;

    public Jogo() {
        dealer = new Dealer();
        jogador1 = new JogadorImpulsivo();
        /*jogador2 = new JogadorImpulsivo();
        jogador3 = new JogadorImpulsivo();
        jogador4 = new JogadorImpulsivo();*/
        mesa = new Pilha<>();
        players = new Queue<>();

        players.enqueue(jogador1);
        /*players.enqueue(jogador2);
        players.enqueue(jogador3);
        players.enqueue(jogador4);*/
    }

    public boolean iniciarJogo() {
        if (players.isEmpty()) {
            System.out.println("Fila vazia!");
            return false;
        } else {
            //1a Rodada
            Carta cartaVirada = dealer.startGame(players, mesa);

            //2a Rodada
            Jogador primeiro = dealer.primeiroValido(players);

            //'Percorre' a fila, removendo os jogadores que não desejam mais cartas,
//e tem como um 'sinalizador' o primeiro jogador encontrado que ainda quer cartas
            if (!players.isEmpty()) {
                do {
                    if (players.peek().logicaDeCartas()) {
                        players.enqueue(players.dequeue());
                    } else {
                        System.out.println(jogoEncerrado(players));
                    }
                } while (!players.peek().equals(primeiro) && !players.isEmpty());

                if (!players.isEmpty()) {
                    //Após remover os jogadores que 'estouraram' com as três cartas atuais, 
//desvira a segunda carta que está na mesa
                    mesa.pop();
                    mesa.push(cartaVirada);
                    if (!players.isEmpty()) {
                        dealer.entregaCartaDaMesa(players, cartaVirada);
                    }

                    //3a e 4a rodadas
                    //A partir daqui, o dealer ficará perguntando ao(s) jogador(es) se quer(em) mais cartas
//e remove os que estouram
                    while (!players.isEmpty()) {
                        while (dealer.pergunta(players.peek())) {
                            players.peek().carta(dealer.entregaCarta());
                        }
                        System.out.println(jogoEncerrado(players));
                    }
                }
            }
            return true;
        }
    }

    //Imprime uma mensagem padrão ao receber uma fila de jogadores, caso seja o ultimo jogador da fila, imprime uma
//de jogo encerrado, caso ainda hajam jogadores, imprime uma mensagem informando que um jogador foi removido
    public static String jogoEncerrado(Queue<Jogador> fila) {
        Jogador primeiro = fila.dequeue();
        if (!fila.isEmpty()) {
            return "Jogador removido!"
                    + "Quantidade de cartas: [ " + primeiro.getTotalCartasJogador() + " ]\n"
                    + "Soma das cartas: [ " + primeiro.getPontuacao() + " ]\n"
                    + "Cartas: " + primeiro.getMao().toString() + "\n\n";
        } else {
            return "Fim de jogo!\n"
                    + "Quantidade de cartas: [ " + primeiro.getTotalCartasJogador() + " ]\n"
                    + "Soma das cartas: [ " + primeiro.getPontuacao() + " ]\n"
                    + "Cartas: " + primeiro.getMao().toString() + "\n\n";
        }
    }

    //Captura a pontuação da carta para adicionar ao jogador
    public static int pontuacaoCarta(Carta x) {
        if (x.getNomeCarta().equalsIgnoreCase("10")
                || x.getNomeCarta().equalsIgnoreCase("Dama")
                || x.getNomeCarta().equalsIgnoreCase("valete")
                || x.getNomeCarta().equalsIgnoreCase("rei")) {
            return 10;
        } else if (x.getNomeCarta().equalsIgnoreCase("as")) {
            return 1;
        } else {
            return Integer.parseInt(x.getNomeCarta());
        }
    }
    /*
    public static void pause() {
        try {
            Thread.sleep(10000);
            //Runtime.getRuntime().getwait(10000);
        } catch (java.lang.InterruptedException ex) {
            ex.printStackTrace();
        }
    }*/
}
