package model;

public class FilaDinamica<T> {
    private Nodo<T> inicio, fim;

    public void enfileirar(T dado) {
        Nodo<T> novo = new Nodo<>(dado);
        if (fim != null) fim.proximo = novo;
        fim = novo;
        if (inicio == null) inicio = fim;
    }

    public T desenfileirar() {
        if (inicio == null) return null;
        T dado = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        return dado;
    }

    public boolean estaVazia() {
        return inicio == null;
    }
}