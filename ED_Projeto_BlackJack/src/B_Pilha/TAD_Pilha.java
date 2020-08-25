/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_Pilha;

/**
 *
 * @author LuanC
 */
public interface TAD_Pilha <E> {
    public int getSize();
    public boolean isEmpty();
    public Node push(E obj);
    public E pop();
    public E top();
    @Override
    public String toString();
}
