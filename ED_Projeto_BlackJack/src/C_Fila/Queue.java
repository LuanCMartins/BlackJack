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
 * @param <E>
 */
public class Queue <E> implements TAD_Queue <E> {

    private Node head = null, tail = null;
    private int size;

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public E peek() {
        if (head == null) {
            return null;
        } else {
            return (E)head.getValue();
        }
    }

    @Override
    public E enqueue(E x) {
        if (x == null) {
            return null;
        }
        try {
            Node novo = new Node();
            novo.setValue(x);
            novo.setNext(null);
            if (tail == null) {
                head = novo;
                tail = novo;
            } else {
                tail.setNext(novo);
                tail = novo;
            }
            size++;
            return (E)x;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public E dequeue() {
        if (head == null) {
            return null;
        }
        E value = (E)head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    @Override
    public ArrayList<E> toArray() {
        if (isEmpty()) {
            return null;
        }
        try {
            ArrayList<E> vetor = new ArrayList<>();
            int i = 0;
            Node aux = head;
            while (aux != null) {
                vetor.add((E)aux.getValue());
                aux = aux.getNext();
            }
            return vetor;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            String saida = "";
            Node aux = head;
            while (aux != null) {
                saida += aux.getValue();
                aux = aux.getNext();
                if (aux != null) {
                    saida += "";
                }
            }
            return (saida);
        } else {
            return "f: []";
        }
    }
}
