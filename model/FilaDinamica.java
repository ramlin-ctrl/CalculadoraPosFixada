package model;

/**
 * Implementação de uma fila dinâmica genérica usando nodos encadeados.
 *
 * @param <T> Tipo dos elementos armazenados na fila.
 */
public class FilaDinamica<T> {
    private Nodo<T> inicio, fim;

    /**
     * Enfileira um novo elemento no final da fila.
     *
     * @param dado O dado a ser enfileirado.
     */
    public void enfileirar(T dado) {
        Nodo<T> novo = new Nodo<>(dado);
        if (fim != null) fim.proximo = novo;
        fim = novo;
        if (inicio == null) inicio = fim;
    }

    /**
     * Desenfileira (remove) o elemento do início da fila.
     *
     * @return O dado removido ou null se a fila estiver vazia.
     */
    public T desenfileirar() {
        if (inicio == null) return null;
        T dado = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        return dado;
    }

    /**
     * Verifica se a fila está vazia.
     *
     * @return true se vazia, false caso contrário.
     */
    public boolean estaVazia() {
        return inicio == null;
    }
}
