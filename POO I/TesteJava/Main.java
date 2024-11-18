import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
  public static void main(String[] args) {
    // Criação da janela
    JFrame frame = new JFrame("Exemplo de JTextField");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setLayout(new GridLayout(3, 2, 5, 5));

    // Criação dos rótulos e campos de texto
    JLabel nameLabel = new JLabel("Nome:");
    JTextField nameField = new JTextField(20);

    JLabel emailLabel = new JLabel("Email:");
    JTextField emailField = new JTextField(20);

    JButton submitButton = new JButton("Enviar");

    // Ação ao clicar no botão "Enviar"
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();
        JOptionPane.showMessageDialog(frame, "Nome: " + name + "\nEmail: " + email);
      }
    });

    // Adiciona os componentes à janela
    frame.add(nameLabel);
    frame.add(nameField);
    frame.add(emailLabel);
    frame.add(emailField);
    frame.add(new JLabel()); // Espaço vazio para ajustar o layout
    frame.add(submitButton);

    // Exibe a janela
    frame.setVisible(true);
  }
}