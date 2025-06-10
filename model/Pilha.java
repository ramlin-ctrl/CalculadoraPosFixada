package model;

/**
 * Implementação de uma pilha genérica usando nodos encadeados.
 *
 * @param <T> Tipo dos elementos armazenados na pilha.
 */
public class Pilha<T> {
    private Nodo<T> topo;
    private int tamanho = 0;

    /**
     * Empilha (adiciona) um elemento no topo da pilha.
     *
     * @param dado O dado a ser empilhado.
     */
    public void empilhar(T dado) {
        Nodo<T> novo = new Nodo<>(dado);
        novo.proximo = topo;
        topo = novo;
        tamanho++;
    }

    /**
     * Desempilha (remove) o elemento do topo da pilha.
     *
     * @return O dado removido ou null se a pilha estiver vazia.
     */
    public T desempilhar() {
        if (topo == null) return null;
        T dado = topo.dado;
        topo = topo.proximo;
        tamanho--;
        return dado;
    }

    /**
     * Verifica se a pilha está vazia.
     *
     * @return true se vazia, false caso contrário.
     */
    public boolean estaVazia() {
        return topo == null;
    }

    /**
     * Retorna o número de elementos na pilha.
     *
     * @return O tamanho da pilha.
     */
    public int tamanho() {
        return tamanho;
    }
}
