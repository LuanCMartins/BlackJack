/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_Pilha;

/**
 *
 * @author LuanC
 * @param <E>
 */
public class Pilha <E> implements TAD_Pilha <E> {

    private int size;
    private Node<E> topo;

    public Pilha() {
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (topo == null);
    }

    @Override
    public Node push(E x) {
        try{
            if (x == null) return null;
            Node novo = new Node();
            novo.setValue(x);
            novo.setNext(topo);
            topo = novo;
            size++;
            return novo;
        } catch(Exception ex){
            return null;
        }
    }

    @Override
    public E pop() {
        if (topo == null) return null;
        E valor = topo.getValue();
        Node temp = topo;
        topo = topo.getNext();
        temp = null;
        size--;
        return (E)valor;
    }

    @Override
    public E top() {
        if (topo == null) return null;
        else return topo.getValue();
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            String resp = "";
            Node aux = topo;
            while(aux!=null){
                resp = aux.getValue().toString() + resp;
                aux = aux.getNext();
                if(aux == null) resp = "" + resp;
            }
            return resp;
        }
        else return("Pilha vazia!");
    }

}
