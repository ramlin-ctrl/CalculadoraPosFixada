package model;

public class Pilha<T> {
    private Nodo<T> topo;
    private int tamanho = 0;

    public void empilhar(T dado) {
        Nodo<T> novo = new Nodo<>(dado);
        novo.proximo = topo;
        topo = novo;
        tamanho++;
    }

    public T desempilhar() {
        if (topo == null) return null;
        T dado = topo.dado;
        topo = topo.proximo;
        tamanho--;
        return dado;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public int tamanho() {
        return tamanho;
    }
}