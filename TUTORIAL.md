# Calculadora Pós-Fixada - Projeto Estrutura de Dados

## Descrição
Este projeto é uma calculadora que processa expressões na notação pós-fixada usando fila dinâmica e pilha.

## Como Executar
1. Clone o repositório:
   git clone https://github.com/ramlin-ctrl/CalculadoraPosFixada

2. Compile e execute a aplicação:
   javac view/Main.java
   java view.Main

## Exemplos

Entrada: 3 4 +
Saída: 7.0

Entrada: 5 1 2 + 4 * + 3 -
Saída: 14.0

Entrada: 10 3 % 4 +
Saída: 5.0

Entrada: 2 3 1 * + 9 -
Saída: -4.0

## Validações
- Divisão por zero
- Operadores inválidos
- Expressão malformada
- Fila e pilha esvaziadas corretamente
