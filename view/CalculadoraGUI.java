package view;

import controller.CalculadoraController;

import javax.swing.*;
import java.awt.*;

/**
 * Classe responsável pela interface gráfica da Calculadora Pós-Fixada.
 * Usa Java Swing para criar a janela e os botões de entrada.
 */
public class CalculadoraGUI extends JFrame {

    // Campo de texto onde a expressão será digitada
    private final JTextField campoExpressao;

    // Label onde será exibido o resultado
    private final JLabel resultado;

    /**
     * Construtor da interface gráfica.
     * Define o layout principal, cor de fundo e componentes visuais.
     */
    public CalculadoraGUI() {
        setTitle("Calculadora Pós-Fixada");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBackground(Color.LIGHT_GRAY);
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Campo para digitar a expressão
        campoExpressao = new JTextField();
        campoExpressao.setFont(new Font("Arial", Font.PLAIN, 18));
        campoExpressao.setBorder(BorderFactory.createTitledBorder("Expressão"));
        painelPrincipal.add(campoExpressao, BorderLayout.NORTH);

        // Área de exibição do resultado
        resultado = new JLabel("Resultado: ");
        resultado.setFont(new Font("Arial", Font.BOLD, 18));
        resultado.setHorizontalAlignment(SwingConstants.CENTER);
        resultado.setBorder(BorderFactory.createTitledBorder("Saída"));
        painelPrincipal.add(resultado, BorderLayout.SOUTH);

        // Adiciona os botões no centro
        JPanel painelBotoes = criarPainelDeBotoes();
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        add(painelPrincipal);
        setVisible(true);
    }

    /**
     * Cria o painel com os botões da calculadora e define suas ações.
     */
    private JPanel criarPainelDeBotoes() {
        JPanel painel = new JPanel(new GridLayout(5, 4, 5, 5));
        painel.setBackground(Color.LIGHT_GRAY);

        String[] botoes = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "0", "%", "/", "=",
                "Espaço", "C"
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 18));
            botao.setBackground(new Color(160, 160, 160)); // cinza escuro
            botao.setForeground(Color.BLACK);
            botao.setFocusPainted(false);
            painel.add(botao);

            botao.addActionListener(e -> {
                String valor = ((JButton) e.getSource()).getText();

                switch (valor) {
                    case "=" -> {
                        String expressao = campoExpressao.getText().trim();
                        String saida = CalculadoraController.calcularExpressao(expressao);
                        resultado.setText("Resultado: " + saida);
                    }
                    case "C" -> {
                        campoExpressao.setText("");
                        resultado.setText("Resultado: ");
                    }
                    case "Espaço" -> campoExpressao.setText(campoExpressao.getText() + " ");
                    default -> campoExpressao.setText(campoExpressao.getText() + valor);
                }
            });
        }

        return painel;
    }

    /**
     * Método principal que inicializa a aplicação.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculadoraGUI::new);
    }
}
