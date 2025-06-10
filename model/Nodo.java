package model;

/**
 * Nodo genérico usado para armazenar dados em estruturas encadeadas.
 *
 * @param <T> Tipo do dado armazenado no nodo.
 */
public class Nodo<T> {
    T dado;
    Nodo<T> proximo;

    /**
     * Construtor do nodo, inicializa com o dado e próximo nodo nulo.
     *
     * @param dado O dado a ser armazenado no nodo.
     */
    public Nodo(T dado) {
        this.dado = dado;
        this.proximo = null;
    }
}
