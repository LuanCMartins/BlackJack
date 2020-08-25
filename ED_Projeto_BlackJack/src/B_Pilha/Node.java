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
public class Node <E> {
    private E value;
    private Node next;

    public E getValue() {
        return (E) value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
