package A_Baralho;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LuanC
 */
public class Carta {
    
    private String nomeCarta;
    private String naipeCarta;
    
    public Carta(String valor, String naipe){
        this.setNomeCarta(valor);
        this.setNaipeCarta(naipe);
    }

    public String getNomeCarta() {
        return nomeCarta;
    }

    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    public String getNaipeCarta() {
        return naipeCarta;
    }

    public void setNaipeCarta(String naipeCarta) {
        this.naipeCarta = naipeCarta;
    }

    @Override
    public String toString() {
        return "| " + nomeCarta + " de " + naipeCarta + " |";
    }
    
    
}
