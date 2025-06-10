package controller;

import model.FilaDinamica;
import model.Pilha;

/**
 * Classe responsável pelo processamento da expressão pós-fixada.
 * Realiza o cálculo da expressão utilizando uma fila dinâmica e uma pilha.
 */
public class CalculadoraController {

    /**
     * Calcula o resultado de uma expressão pós-fixada.
     * 
     * @param expressao A expressão pós-fixada a ser calculada, com tokens separados por espaços.
     * @return O resultado da expressão ou uma mensagem de erro caso a expressão seja inválida.
     */
    public static String calcularExpressao(String expressao) {
        FilaDinamica<String> fila = new FilaDinamica<>();
        Pilha<Double> pilha = new Pilha<>();

        String[] tokens = expressao.trim().split("\\s+");

        for (String token : tokens) {
            fila.enfileirar(token);
        }

        while (!fila.estaVazia()) {
            String elemento = fila.desenfileirar();

            try {
                double numero = Double.parseDouble(elemento);
                pilha.empilhar(numero);
            } catch (NumberFormatException e) {
                if (pilha.tamanho() < 2) {
                    return "Erro: operandos insuficientes.";
                }

                double b = pilha.desempilhar();
                double a = pilha.desempilhar();
                double resultado;

                switch (elemento) {
                    case "+":
                        resultado = a + b;
                        break;
                    case "-":
                        resultado = a - b;
                        break;
                    case "*":
                        resultado = a * b;
                        break;
                    case "/":
                        if (b == 0) return "Erro: divisão por zero.";
                        resultado = a / b;
                        break;
                    case "%":
                        if (b == 0) return "Erro: divisão por zero.";
                        resultado = a % b;
                        break;
                    default:
                        return "Erro: operador inválido '" + elemento + "'";
                }

                pilha.empilhar(resultado);
            }
        }

        if (pilha.tamanho() != 1) {
            return "Erro: expressão malformada (pilha final com múltiplos valores)";
        }

        return String.valueOf(pilha.desempilhar());
    }
}
