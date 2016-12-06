/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps3;

/**
 *
 * @author alexia-gomes
 */

public class ListaDE<T> implements Iterable<T> {

    private No head;
    private No tail;

    public No getHead() {
        return head;
    }

    public No getTail() {
        return tail;
    }

    void append(T valor) {
        No novo = new No(valor);

        if (tail != null) {
            novo.anterior = tail;
            tail.next = novo;
        } else {
            head = novo;
        }

        tail = novo;
    }

    void append(T valor, No paraTras) {
        No novo = new No(valor);

        if (tail != null) {
            novo.anterior = tail;
            tail.next = novo;
        } else {
            head = novo;
        }

        novo.paraTras = paraTras;

        tail = novo;
    }

    protected class No {

        private T data;
        private No anterior;
        private No next;
        private No paraTras;

        public No(T valor) {
            data = valor;
        }

        public No getNext() {
            return next;
        }

        public No getAnterior() {
            return anterior;
        }

        public T getData() {
            return data;
        }

        public No getParaTras() {
            return paraTras;
        }
    }

    private class ListIterator implements Iterador<T> {

        private No current = null;
        private No anterior = null;

        @Override
        public No getCurrent() {
            return current;
        }

        @Override
        public boolean hasNext() {
            if (current == null) {
                return head != null;
            }
            return current.next != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("Sem next!");
            }

            if (current == null) {
                current = head;
            } else {
                anterior = current;
                current = current.next;
            }

            return current.data;
        }

        @Override
        public void append(T dado) {
            if (current == null) {
                throw new IllegalStateException("Use next()!");
            }

            No no = new No(dado);
            No next = current.next;

            no.next = next;
            no.anterior = current;

            current.next = no;

            if (current == tail) {
                tail = no;
            }
        }

        @Override
        public void append(T dado, No paraTras) {
            if (current == null) {
                throw new IllegalStateException("");
            }

            No no = new No(dado);
            No next = current.next;

            no.next = next;
            no.anterior = current;

            current.next = no;
            current.paraTras = paraTras;

            if (current == tail) {
                tail = no;
            }
        }

        @Override
        public void insert(T dado) {
            if (current == null) {
                throw new IllegalStateException("Use next()!");
            }

            No no = new No(dado);

            no.next = current;
            current.anterior = no;

            if (anterior != null) {
                no.anterior = anterior;
                anterior.next = no;
            } else {
                head = no;
            }
        }
        
        @Override
        public void remove() {
            if (current == null) {
                throw new IllegalStateException("Use next()!");
            }

            No next = current.next;

            if (anterior == null) {
                head = next;
            } else {
                anterior.next = next;
            }

            if (next == null) {
                tail = anterior;
            } else {
                next.anterior = anterior;
            }
        }

    }
    
    public Iterador<T> iterator() {
        return new ListIterator();
    }
}//Fecha classe principal.

