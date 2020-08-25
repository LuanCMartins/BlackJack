/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IAs;

import A_Baralho.Carta;
import B_Pilha.Pilha;

/**
 *
 * @author Lorenzetti
 */
public abstract class Jogador {

    private int qntcartasjogador = 0;
    private int pontuacao = 0;
    private Pilha<Carta> mao = new Pilha<>();

    public int getTotalCartasJogador() {
        return qntcartasjogador;
    }

    public void setCartasJogador(int cartasJogador) {
        this.qntcartasjogador = cartasJogador;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Pilha<Carta> getMao() {
        return this.mao;
    }
    
    public Carta carta(Carta x) {
        if (x != null) {
            mao.push(x);
            this.qntcartasjogador++;
            pontuacao += Jogo.pontuacaoCarta(x);
            return x;
        }
        else return null;
    }
    
    public boolean logicaDeCartas(){
        return false;
    }

}
