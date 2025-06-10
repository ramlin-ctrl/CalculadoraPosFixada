package model;

public class Nodo<T> {
    T dado;
    Nodo<T> proximo;

    public Nodo(T dado) {
        this.dado = dado;
        this.proximo = null;
    }
}