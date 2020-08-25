/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IAs;


/**
 *
 * @author LuanC
 */
public class JogadorImpulsivo extends Jogador {

    public JogadorImpulsivo(){
        super.getTotalCartasJogador();
        super.getPontuacao();
        super.getMao();
    }
    
    @Override
    public boolean logicaDeCartas() {
        return super.getPontuacao() < 21;
    }
    
}
