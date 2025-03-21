import javax.swing.*;

public class AppManipulacaoArquivo {
  public static void main(String[] args) {
    // Configura o look and feel
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      System.err.println("Erro ao configurar interface: " + e.getMessage());
    }
    
    // Inicia a GUI
    SwingUtilities.invokeLater(() -> {
      try {
        InterfaceArquivoSwing interfaceArquivo = new InterfaceArquivoSwing();
        interfaceArquivo.setVisible(true);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao iniciar aplicação: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
      }
    });
  }
}