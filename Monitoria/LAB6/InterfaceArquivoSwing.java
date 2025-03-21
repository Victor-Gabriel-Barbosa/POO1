import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfaceArquivoSwing extends JFrame {
  private final criarArquivoTexto arquivoTexto;
  private final JButton btnAbrirArquivo;
  private final JButton btnInserirRegistro;
  private final JButton btnFecharArquivo;
  private final JButton btnSair;
  private final JTextArea areaLog;

  public InterfaceArquivoSwing() {
    // Inicialização
    arquivoTexto = new criarArquivoTexto();

    // Configura a janela
    setTitle("Manipulação de Arquivo");
    setSize(500, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    // Adiciona listener para confirmar saída
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        confirmarSaida();
      }
    });

    // Painel de botões
    JPanel painelBotoes = new JPanel();
    painelBotoes.setLayout(new GridLayout(1, 4, 10, 0));

    btnAbrirArquivo = new JButton("Abrir Arquivo");
    btnInserirRegistro = new JButton("Inserir Registro");
    btnFecharArquivo = new JButton("Fechar Arquivo");
    btnSair = new JButton("Sair");

    // Adiciona botões ao painel
    painelBotoes.add(btnAbrirArquivo);
    painelBotoes.add(btnInserirRegistro);
    painelBotoes.add(btnFecharArquivo);
    painelBotoes.add(btnSair);

    // Área de log
    areaLog = new JTextArea();
    areaLog.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(areaLog);

    // Layout principal
    setLayout(new BorderLayout(10, 10));
    add(painelBotoes, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);

    // Configura margens
    ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Configura listeners para botões
    configurarEventos();

    // Estado inicial dos botões
    atualizarEstadoBotoes();

    log("Aplicação iniciada. Selecione uma opção.");
  }

  private void configurarEventos() {
    btnAbrirArquivo.addActionListener(e -> abrirArquivo());
    btnInserirRegistro.addActionListener(e -> inserirRegistro());
    btnFecharArquivo.addActionListener(e -> fecharArquivo());
    btnSair.addActionListener(e -> confirmarSaida());
  }

  private void abrirArquivo() {
    if (arquivoTexto.abrirArquivo()) {
      log("Arquivo aberto com sucesso.");
      atualizarEstadoBotoes();
    } else log("Falha ao abrir o arquivo.");
  }

  private void inserirRegistro() {
    try {
      // Campos para entrada de dados
      JTextField campoNumConta = new JTextField(10);
      JTextField campoNome = new JTextField(15);
      JTextField campoSaldo = new JTextField(10);

      // Painel para entrada de dados
      JPanel painel = new JPanel();
      painel.setLayout(new GridLayout(3, 2, 5, 5));
      painel.add(new JLabel("Número da Conta:"));
      painel.add(campoNumConta);
      painel.add(new JLabel("Nome:"));
      painel.add(campoNome);
      painel.add(new JLabel("Saldo:"));
      painel.add(campoSaldo);

      // Exibe diálogo para entrada de dados
      int resultado = JOptionPane.showConfirmDialog(
        this, painel, "Inserir Registro",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
      );

      // Processa entrada se o usuário clicar em OK
      if (resultado == JOptionPane.OK_OPTION) {
        int conta = Integer.parseInt(campoNumConta.getText());
        String nome = campoNome.getText();
        double saldo = Double.parseDouble(campoSaldo.getText());

        // Valida entrada
        if (conta <= 0) {
          JOptionPane.showMessageDialog(this, "Número da conta deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
          return;
        }

        if (nome.trim().isEmpty()) {
          JOptionPane.showMessageDialog(this, "Nome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
          return;
        }

        // Cria e salva registro
        gravarRegistros registro = new gravarRegistros(conta, nome, saldo);
        if (arquivoTexto.adicionarRegistro(registro)) log(String.format("Registro adicionado: Conta=%d, Nome=%s, Saldo=%.2f", conta, nome, saldo));
        else log("Falha ao adicionar registro.");
      }
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this,
        "Formato numérico inválido. Verifique os valores digitados.",
        "Erro de Formato", JOptionPane.ERROR_MESSAGE
      );
      log("Erro ao inserir registro: formato numérico inválido");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Erro ao inserir registro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
      log("Erro ao inserir registro: " + e.getMessage());
    }
  }

  private void fecharArquivo() {
    if (arquivoTexto.fecharArquivo()) log("Arquivo fechado com sucesso.");
    else log("Arquivo já está fechado ou não foi aberto.");
    atualizarEstadoBotoes();
  }

  private void confirmarSaida() {
    int opcao = JOptionPane.showConfirmDialog(
      this, "Deseja realmente sair?",
      "Confirmar Saída", JOptionPane.YES_NO_OPTION
    );

    if (opcao == JOptionPane.YES_OPTION) {
      // Fecha arquivo se estiver aberto
      if (arquivoTexto.isArquivoAberto()) {
        arquivoTexto.fecharArquivo();
        log("Arquivo fechado automaticamente.");
      }
      dispose();
      System.exit(0);
    }
  }

  private void atualizarEstadoBotoes() {
    boolean arquivoAberto = arquivoTexto.isArquivoAberto();
    btnAbrirArquivo.setEnabled(!arquivoAberto);
    btnInserirRegistro.setEnabled(arquivoAberto);
    btnFecharArquivo.setEnabled(arquivoAberto);
  }

  private void log(String mensagem) {
    areaLog.append(mensagem + "\n");
    // Rola para a última linha
    areaLog.setCaretPosition(areaLog.getDocument().getLength());
  }
}