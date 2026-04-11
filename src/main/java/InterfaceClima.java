import javax.swing.*;
import java.awt.*;

public class InterfaceClima extends JFrame {

    private JTextField campoCidade;
    private JLabel labelTemperatura;
    private JLabel labelVento;
    private JLabel labelCidade;
    private JLabel labelEmoji;

    public InterfaceClima() {
        setTitle("App de Clima");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 🔹 Painel topo (busca)
        JPanel painelTopo = new JPanel(new FlowLayout());
        campoCidade = new JTextField(15);
        JButton botaoBuscar = new JButton("Buscar");

        painelTopo.add(new JLabel("Cidade:"));
        painelTopo.add(campoCidade);
        painelTopo.add(botaoBuscar);

        // 🔹 Painel central (vertical)
        JPanel painelDados = new JPanel(new GridLayout(4, 1, 10, 10));

        labelEmoji = new JLabel("🌤", SwingConstants.CENTER);
        labelEmoji.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 40));

        labelCidade = new JLabel("Cidade: -", SwingConstants.CENTER);
        labelTemperatura = new JLabel("Temperatura: -", SwingConstants.CENTER);
        labelVento = new JLabel("Vento: -", SwingConstants.CENTER);

        // 🔥 Fontes maiores
        labelCidade.setFont(new Font("Arial", Font.BOLD, 16));
        labelTemperatura.setFont(new Font("Arial", Font.BOLD, 18));
        labelVento.setFont(new Font("Arial", Font.PLAIN, 16));

        painelDados.add(labelEmoji);       // espaço do emoji
        painelDados.add(labelCidade);
        painelDados.add(labelTemperatura);
        painelDados.add(labelVento);

        add(painelTopo, BorderLayout.NORTH);
        add(painelDados, BorderLayout.CENTER);

        // 🔹 Ação do botão
        botaoBuscar.addActionListener(e -> {
            String cidade = campoCidade.getText();
            if (!cidade.isEmpty()) {
                Principal.buscarDadosParaTela(cidade, this);
            } else {
                mostrarErro("Digite uma cidade.");
            }
        });
    }

    public void atualizarCampos(double temp, double vento, String cidade) {
        SwingUtilities.invokeLater(() -> {

            labelCidade.setText("Cidade: " + cidade);
            labelTemperatura.setText("Temperatura: " + temp + "°C");
            labelVento.setText("Vento: " + vento + " km/h");

            // 🌡️ Lógica do emoji
            if (temp >= 30) {
                labelEmoji.setText("🌞"); // calor forte
            } else if (temp >= 20) {
                labelEmoji.setText("🌤"); // clima agradável
            } else {
                labelEmoji.setText("❄️"); // frio
            }
        });
    }

    public void mostrarErro(String msg) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(this, msg);
        });
    }
}