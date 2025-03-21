/* Resumo dos principais componentes Swing:
 * 
 * JFrame - janela principal
 * JPanel - painéis para organizar componentes
 * JLabel - rótulos de texto
 * JTextField - campo de texto de linha única
 * JButton - botão clicável
 * JCheckBox - caixa de seleção
 * JRadioButton - botões de opção
 * ButtonGroup - para agrupar botões de opção
 * JComboBox - lista suspensa
 * JTextArea - área de texto com múltiplas linhas
 * JScrollPane - painel com barra de rolagem
 */

import javax.swing.*;
import java.awt.*;

public class ExemploSwing extends JFrame {
  private JTextField campoTexto;
  private JButton botao;
  private JLabel rotulo;
  private JCheckBox caixaSelecao;
  private JRadioButton opcaoRadio1, opcaoRadio2;
  private JComboBox<String> comboBox;
  private JTextArea areaTexto;

  public ExemploSwing() {
    // Configuração da janela principal
    super("Exemplo de Componentes Swing");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 400);
    setLayout(new BorderLayout(10, 10));

    // Painel superior com campo de texto e botão
    JPanel painelSuperior = new JPanel();
    campoTexto = new JTextField(20);
    botao = new JButton("Clique Aqui");
    rotulo = new JLabel("Resultado:");

    painelSuperior.add(new JLabel("Digite algo:"));
    painelSuperior.add(campoTexto);
    painelSuperior.add(botao);
    painelSuperior.add(rotulo);

    // Painel central com componentes diversos
    JPanel painelCentral = new JPanel();
    painelCentral.setLayout(new GridLayout(4, 1, 5, 5));

    // Checkbox
    caixaSelecao = new JCheckBox("Ativar opção");

    // Radio buttons
    ButtonGroup grupo = new ButtonGroup();
    opcaoRadio1 = new JRadioButton("Opção 1", true);
    opcaoRadio2 = new JRadioButton("Opção 2");
    grupo.add(opcaoRadio1);
    grupo.add(opcaoRadio2);

    JPanel painelRadio = new JPanel();
    painelRadio.add(opcaoRadio1);
    painelRadio.add(opcaoRadio2);

    // ComboBox
    String[] opcoes = { "Item 1", "Item 2", "Item 3", "Item 4" };
    comboBox = new JComboBox<>(opcoes);

    painelCentral.add(caixaSelecao);
    painelCentral.add(painelRadio);
    painelCentral.add(comboBox);

    // Área de texto com scroll
    areaTexto = new JTextArea(5, 20);
    areaTexto.setLineWrap(true);
    JScrollPane scrollPane = new JScrollPane(areaTexto);

    // Adiciona os painéis à janela principal
    add(painelSuperior, BorderLayout.NORTH);
    add(painelCentral, BorderLayout.CENTER);
    add(scrollPane, BorderLayout.SOUTH);

    // Configuração dos eventos
    botao.addActionListener(e -> {
      String texto = campoTexto.getText();
      areaTexto.append("Texto digitado: " + texto + "\n");

      if (caixaSelecao.isSelected()) {
        areaTexto.append("Caixa de seleção está marcada\n");
      }

      String opcaoRadio = opcaoRadio1.isSelected() ? "Opção 1" : "Opção 2";
      areaTexto.append("Opção de rádio selecionada: " + opcaoRadio + "\n");

      areaTexto.append("Item selecionado no ComboBox: " + comboBox.getSelectedItem() + "\n");

      rotulo.setText("Processado!");
    });
  }

  public static void main(String[] args) {
    // Executa a interface gráfica
    SwingUtilities.invokeLater(() -> {
      new ExemploSwing().setVisible(true);
    });
  }
}