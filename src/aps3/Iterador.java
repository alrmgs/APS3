package aps3;

import java.util.Iterator;

public interface Iterador<T> extends Iterator<T> {

    void append(T dado, ListaDE<T>.No no);

    void append(T dado);

    void insert(T dado);

    ListaDE<T>.No getCurrent();
}//Fecha classe principal.
