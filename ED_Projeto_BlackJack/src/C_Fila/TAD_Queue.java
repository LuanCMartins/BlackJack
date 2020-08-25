/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_Fila;
import java.util.ArrayList;

/**
 *
    * @author LuanC
 */
public abstract interface TAD_Queue <E> {
    public boolean isEmpty();
    public E enqueue(E x);
    public E dequeue();
    public ArrayList<E> toArray();
    public E peek();
    @Override
    public String toString();
}
