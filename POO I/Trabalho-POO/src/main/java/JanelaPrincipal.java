import javax.swing.*; // 📦 Importa as bibliotecas necessárias para construir a interface gráfica
import java.awt.*; // 📦 Importa as classes para gerenciamento de layouts e cores
import java.awt.event.MouseAdapter; // 📋 Importa o adapter para capturar eventos de mouse
import java.awt.event.MouseEvent; // 📋 Importa o evento de mouse
import java.awt.event.MouseWheelEvent; // 📦 Importa a classe para o evento de rolagem do mouse
import java.awt.event.MouseWheelListener; // 📦 Importa a classe para o listener de rolagem do mouse


public class JanelaPrincipal extends JFrame { // 🖥️ Classe que representa a janela principal do programa
  private Galeria galeria; // 🖼️ Instância da galeria de artes
  private JPanel painelPrincipal; // 🗂️ Painel principal que contém todos os elementos
  private JPanel painelArtes; // 🖼️ Painel onde as artes serão exibidas

  public JanelaPrincipal() { // 🏗️ Construtor da janela principal
    galeria = new Galeria(); // 🖼️ Inicializa a galeria com as artes
    inicializarUI(); // 🛠️ Chama o método para configurar a interface gráfica
  }

  private void inicializarUI() { // 🛠️ Método para configurar a interface gráfica
    setTitle("Galeria Gótica & Nouveau"); // 📑 Define o título da janela
    setSize(800, 600); // 📏 Define o tamanho da janela
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // 🛑 Define para não fechar automaticamente

    // 🔒 Adiciona o listener para confirmação de saída
    addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosing(java.awt.event.WindowEvent e) { // 📥 Evento de fechamento da janela
        int resposta = JOptionPane.showConfirmDialog(
          null,
          "Tem certeza que deseja sair?", // ❓ Mensagem de confirmação
          "Confirmação de Saída", // 📑 Título da caixa de diálogo
          JOptionPane.YES_NO_OPTION // 🗂️ Opções "Sim" e "Não"
        );

        if (resposta == JOptionPane.YES_OPTION) { // ✔️ Se o usuário confirmar, fecha o programa
          dispose(); // 🗑️ Libera recursos e fecha a janela
          System.exit(0); // 🛑 Encerra o programa
        }
      }
    });

    painelPrincipal = new JPanel(new BorderLayout()); // 🗂️ Cria o painel principal com layout de borda
    painelPrincipal.setBackground(new Color(25, 20, 20)); // 🎨 Define a cor de fundo escura
    painelArtes = new JPanel(new GridLayout(0, 3, 10, 10)); // 🖼️ Cria painel para artes com grid de 3 colunas
    painelArtes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 🖼️ Adiciona margens ao painel
    painelArtes.setBackground(new Color(34, 34, 34)); // 🎨 Define a cor de fundo do painel de artes

    adicionarMenu(); // 🛠️ Adiciona o menu de opções
    adicionarCategorias(); // 🛠️ Adiciona as abas para categorias (Arte Gótica, Arte Nouveau)
    mostrarGaleria("Gótica"); // 🖼️ Exibe a galeria da categoria Gótica inicialmente

    add(painelPrincipal); // 📥 Adiciona o painel principal à janela
  }

  private void adicionarMenu() { // 🍽️ Método para adicionar o menu
    JMenuBar menuBar = new JMenuBar(); // 🍴 Cria a barra de menu
    menuBar.setBackground(new Color(50, 50, 50)); // 🎨 Define a cor de fundo da barra de menu

    JMenu menuArquivo = new JMenu("Arquivo"); // 📂 Cria o menu 'Arquivo'
    menuArquivo.setForeground(Color.LIGHT_GRAY); // 🎨 Define a cor do texto do menu

    JMenuItem itemSair = new JMenuItem("Sair"); // ❌ Cria o item de menu 'Sair'
    itemSair.addActionListener(e -> System.exit(0)); // ⚙️ Adiciona ação para fechar o aplicativo
    menuArquivo.add(itemSair); // 📥 Adiciona o item ao menu 'Arquivo'

    JMenuItem itemAdicionarArte = new JMenuItem("Adicionar Arte"); // ➕ Cria o item 'Adicionar Arte'
    itemAdicionarArte.addActionListener(e -> { // ⚙️ Ação de adicionar arte
      JanelaAdicionarArte janelaAdicionar = new JanelaAdicionarArte(galeria, this); // 🖼️ Abre a janela para adicionar arte
      janelaAdicionar.setVisible(true); // 👀 Torna a janela de adicionar arte visível
    });
    menuArquivo.add(itemAdicionarArte); // 📥 Adiciona o item ao menu 'Arquivo'

    // Adicionando o item para remover arte
    JMenuItem itemRemoverArte = new JMenuItem("Remover Arte"); // ❌ Cria o item 'Remover Arte'
    itemRemoverArte.addActionListener(e -> { // ⚙️ Ação de remover arte
      JanelaRemoverArte janelaRemover = new JanelaRemoverArte(galeria, this); // 🖼️ Abre a janela para remover arte
      janelaRemover.setVisible(true); // 👀 Torna a janela de remover arte visível
    });
    menuArquivo.add(itemRemoverArte); // 📥 Adiciona o item ao menu 'Arquivo'

    menuBar.add(menuArquivo); // 📥 Adiciona o menu 'Arquivo' à barra de menus
    setJMenuBar(menuBar); // 📋 Define a barra de menu para a janela
  }

  private void adicionarCategorias() { // 🖼️ Método para adicionar abas de categorias
    JTabbedPane tabbedPane = new JTabbedPane(); // 📑 Cria o JTabbedPane para as categorias
    tabbedPane.setBackground(new Color(0, 206, 209)); // 🎨 Define a cor de fundo das abas

    // Criando o painel para Arte Gótica
    JPanel painelGotico = new JPanel();
    painelGotico.setLayout(new BorderLayout()); // 📏 Define o layout do painel
    painelGotico.setBackground(new Color(34, 34, 34)); // 🎨 Define o fundo escuro para a aba

    // Texto explicativo para a Arte Gótica
    String textoGotico = "<html><div style='padding:10px; font-size:14px; color:white;'>"
        + "<strong>Arte Gótica</strong><br>"
        + "A arte gótica surgiu na França no século XII e durou até o final do século XV. Caracteriza-se por sua verticalidade, "
        + "com grandes vitrais, arcos ogivais e uma busca por iluminar e elevar espiritualmente o espectador. A arquitetura gótica "
        + "é especialmente famosa por suas catedrais e igrejas com vitrais coloridos, que retratam cenas religiosas."
        + "</div></html>";
    JLabel labelGotico = new JLabel(textoGotico);
    painelGotico.add(labelGotico, BorderLayout.CENTER); // Adiciona o texto explicativo à aba de Arte Gótica

    tabbedPane.addTab("Arte Gótica", painelGotico); // 📥 Adiciona a aba "Arte Gótica"

    // Criando o painel para Arte Nouveau
    JPanel painelNouveau = new JPanel();
    painelNouveau.setLayout(new BorderLayout()); // 📏 Define o layout do painel
    painelNouveau.setBackground(new Color(34, 34, 34)); // 🎨 Define o fundo escuro para a aba

    // Texto explicativo para a Arte Nouveau
    String textoNouveau = "<html><div style='padding:10px; font-size:14px; color:white;'>"
        + "<strong>Arte Nouveau</strong><br>"
        + "A Arte Nouveau, ou Art Nouveau, foi um movimento artístico que floresceu na Europa no final do século XIX e início do século XX. "
        + "É conhecida pelo uso de linhas curvas e formas inspiradas na natureza, como flores, folhas e vinhas. A Art Nouveau esteve presente em "
        + "diversas manifestações artísticas, como arquitetura, mobiliário, pintura e design de vidro. Esse estilo buscava romper com os "
        + "padrões tradicionais da arte acadêmica da época."
        + "</div></html>";
    JLabel labelNouveau = new JLabel(textoNouveau);
    painelNouveau.add(labelNouveau, BorderLayout.CENTER); // Adiciona o texto explicativo à aba de Arte Nouveau

    tabbedPane.addTab("Arte Nouveau", painelNouveau); // 📥 Adiciona a aba "Arte Nouveau"

    // Adiciona listener para mudança de aba
    tabbedPane.addChangeListener(e -> { 
      int selectedIndex = tabbedPane.getSelectedIndex(); // 📏 Obtém o índice da aba selecionada
      if (selectedIndex == 0) { // Caso a aba de Arte Gótica seja selecionada
        mostrarGaleria("Gótica"); // 🖼️ Exibe a galeria de arte Gótica
      } else if (selectedIndex == 1) { // Caso a aba de Arte Nouveau seja selecionada
        mostrarGaleria("Nouveau"); // 🖼️ Exibe a galeria de arte Nouveau
      }
    });

    painelPrincipal.add(tabbedPane, BorderLayout.NORTH); // 📥 Adiciona o JTabbedPane ao painel principal
  }

  public void mostrarGaleria(String categoria) { // 🖼️ Método para exibir as artes filtradas pela categoria
    painelArtes.removeAll(); // 🚮 Remove todas as artes existentes do painel

    // Remove o JScrollPane existente, se houver
    for (Component comp : painelPrincipal.getComponents()) { // 🔄 Percorre os componentes do painel principal
      if (comp instanceof JScrollPane) { // 🔍 Verifica se o componente é um JScrollPane
        painelPrincipal.remove(comp); // 🚮 Remove o JScrollPane
        break; // 🚶‍♂️ Interrompe o loop após encontrar o JScrollPane
      }
    }

    // Adiciona as artes da categoria selecionada
    for (Arte arte : galeria.getArtesPorCategoria(categoria)) { // 🔄 Percorre todas as artes da categoria
      JPanel painelArte = criarPainelArte(arte); // 🖼️ Cria um painel para cada arte
      painelArtes.add(painelArte); // 📥 Adiciona o painel de arte ao painel de artes
    }

    painelArtes.revalidate(); // 🔄 Recalcula a exibição do painel de artes
    painelArtes.repaint(); // 🖼️ Reexibe o painel de artes

    JScrollPane scrollPane = new JScrollPane(painelArtes); // 📜 Cria um scroll para a área das artes
    painelPrincipal.add(scrollPane, BorderLayout.CENTER); // 📥 Adiciona o JScrollPane ao painel principal
    painelPrincipal.revalidate(); // 🔄 Recalcula a exibição do painel principal
    painelPrincipal.repaint(); // 🖼️ Reexibe o painel principal
  }

  private JPanel criarPainelArte(Arte arte) {
    JPanel painelArte = new JPanel(); // 🖼️ Cria o painel da arte
    painelArte.setLayout(new BorderLayout()); // 📏 Define o layout do painel de arte
    painelArte.setBorder(BorderFactory.createLineBorder(new Color(70, 50, 50), 2)); // 🎨 Adiciona borda ao painel de arte
    painelArte.setBackground(new Color(45, 40, 40)); // 🎨 Define a cor de fundo para o painel de arte

    // Carregar a imagem e redimensioná-la
    ImageIcon imagemOriginal = new ImageIcon(arte.getImagemCaminho()); // 🖼️ Carrega a imagem
    Image imagemRedimensionada = imagemOriginal.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // 🔽 Tamanho reduzido
    JLabel labelImagem = new JLabel(new ImageIcon(imagemRedimensionada)); // 🖼️ Usar a imagem redimensionada

    labelImagem.setHorizontalAlignment(SwingConstants.CENTER); // 📐 Alinha a imagem ao centro

    // Painel de informações
    JPanel painelInfo = new JPanel(new BorderLayout()); // 🗂️ Cria o painel de informações da arte
    painelInfo.setBackground(new Color(35, 30, 30)); // 🎨 Define a cor de fundo do painel de informações

    JLabel labelTitulo = new JLabel(arte.getTitulo()); // 🖋️ Cria um rótulo com o título da arte
    labelTitulo.setForeground(Color.LIGHT_GRAY); // 🎨 Define a cor do texto como cinza claro
    labelTitulo.setFont(new Font("Arial", Font.BOLD, 14)); // 📖 Define a fonte do título

    painelInfo.add(labelTitulo, BorderLayout.NORTH); // 📥 Adiciona o título ao painel de informações

    painelArte.add(labelImagem, BorderLayout.CENTER); // 📥 Adiciona a imagem ao painel de arte
    painelArte.add(painelInfo, BorderLayout.SOUTH); // 📥 Adiciona as informações ao painel de arte

    // Adicionar evento de clique para maximizar a imagem
    labelImagem.addMouseListener(new MouseAdapter() { // 🖱️ Evento de clique para maximizar
      @Override
      public void mouseClicked(MouseEvent e) {
        maximizarImagem(arte); // 🖼️ Maximiza a imagem quando clicada
      }
    });

    return painelArte; // 🖼️ Retorna o painel da arte
  }

  private void maximizarImagem(Arte arte) {
    // 🖼️ Cria uma janela para exibir a imagem maximizada
    JFrame janelaMaximizada = new JFrame("Arte Maximizada");
    janelaMaximizada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // 🖼️ Carrega a imagem original
    ImageIcon imagemOriginal = new ImageIcon(arte.getImagemCaminho());

    // 📏 Calcula as proporções para redimensionar a imagem de forma proporcional
    int larguraJanela = 800;
    int alturaJanela = 600;

    int larguraImagemOriginal = imagemOriginal.getIconWidth();
    int alturaImagemOriginal = imagemOriginal.getIconHeight();

    // 🔢 Calcula o fator de escala para manter a imagem proporcional
    double escalaLargura = (double) larguraJanela / larguraImagemOriginal;
    double escalaAltura = (double) alturaJanela / alturaImagemOriginal;
    double fatorEscala = Math.min(escalaLargura, escalaAltura); // 🔎 Determina o fator de escala

    // 🔄 Redimensiona a imagem para caber na janela
    int novaLargura = (int) (larguraImagemOriginal * fatorEscala);
    int novaAltura = (int) (alturaImagemOriginal * fatorEscala);
    Image imagemRedimensionada = imagemOriginal.getImage().getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);

    // 🖼️ Cria o JLabel para exibir a imagem redimensionada
    JLabel labelImagemMaximizada = new JLabel(new ImageIcon(imagemRedimensionada));

    // 📏 Centraliza a imagem na janela inicial
    JScrollPane painelDeRolagem = new JScrollPane(labelImagemMaximizada);
    painelDeRolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // 📜 Barra de rolagem horizontal
    painelDeRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 📜 Barra de rolagem vertical

    // 🎨 Cria o painel com a imagem e o fundo escuro
    JPanel painelImagem = new JPanel();
    painelImagem.setBackground(new Color(35, 30, 30));  // 🖤 Define o fundo escuro
    painelImagem.setLayout(new BorderLayout());
    painelImagem.add(painelDeRolagem, BorderLayout.CENTER);

    // 🖼️ Cria um painel para exibir as informações da obra
    JPanel painelInformacoes = new JPanel();
    painelInformacoes.setBackground(new Color(35, 30, 30)); // 🖤 Fundo escuro
    painelInformacoes.setLayout(new BoxLayout(painelInformacoes, BoxLayout.Y_AXIS)); // Organiza as informações em uma coluna

    // 📝 Adiciona as informações da obra de arte no painel
    JLabel tituloLabel = new JLabel("Título: " + arte.getTitulo());
    tituloLabel.setForeground(Color.WHITE); // Define a cor da fonte
    tituloLabel.setPreferredSize(new Dimension(larguraJanela, 30));  // Define um tamanho preferido

    JLabel autorLabel = new JLabel("Artista: " + arte.getArtista());
    autorLabel.setForeground(Color.WHITE);
    autorLabel.setPreferredSize(new Dimension(larguraJanela, 30));

    JLabel descricaoLabel = new JLabel("<html>Descrição: " + arte.getDescricao() + "</html>"); // Usa HTML para quebra automática de linha
    descricaoLabel.setForeground(Color.WHITE);
    descricaoLabel.setPreferredSize(new Dimension(larguraJanela, 60)); // Ajuste de tamanho conforme necessário

    // 🧳 Adiciona os rótulos ao painel de informações
    painelInformacoes.add(tituloLabel);
    painelInformacoes.add(autorLabel);
    painelInformacoes.add(descricaoLabel);

    // 🖼️ Coloca as informações em um JScrollPane para permitir rolagem se necessário
    JScrollPane scrollPaneInformacoes = new JScrollPane(painelInformacoes);
    scrollPaneInformacoes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Rolagem vertical conforme necessário

    // 🖼️ Cria um painel principal para a imagem e as informações
    JPanel painelPrincipal = new JPanel();
    painelPrincipal.setLayout(new BorderLayout());
    painelPrincipal.add(painelImagem, BorderLayout.CENTER);
    painelPrincipal.add(scrollPaneInformacoes, BorderLayout.SOUTH); // Adiciona as informações na parte inferior

    // 🖼️ Adiciona o painel à janela
    janelaMaximizada.add(painelPrincipal);

    // 📏 Ajusta o tamanho da janela para 800x600
    janelaMaximizada.setSize(larguraJanela, alturaJanela);
    janelaMaximizada.setLocationRelativeTo(null); // 🏠 Centraliza a janela na tela
    janelaMaximizada.setVisible(true); // 👁️ Torna a janela visível

    // 🖱️ Adiciona o listener de zoom com a roda do mouse
    painelDeRolagem.addMouseWheelListener(new MouseWheelListener() {
      private final double FATOR_ZOOM_MAX = 5.0;  // 🔝 Limite máximo de zoom
      private final double FATOR_ZOOM_MIN = 0.1; // 🔽 Limite mínimo de zoom

      @Override
      public void mouseWheelMoved(MouseWheelEvent e) {
        // 🖱️ Obtém o ponto onde o mouse está localizado
        Point pontoMouse = e.getPoint();

        // 🔢 Obtém as dimensões atuais da imagem
        int larguraAtual = labelImagemMaximizada.getIcon().getIconWidth();
        int alturaAtual = labelImagemMaximizada.getIcon().getIconHeight();

        // 🔄 Determina o fator de zoom (1.1 para aumentar, 0.9 para diminuir)
        double zoomFactor = (e.getWheelRotation() < 0) ? 1.1 : 0.9;

        // 🔢 Calcula as novas dimensões da imagem após o zoom
        int novaLarguraZoom = (int) (larguraAtual * zoomFactor);
        int novaAlturaZoom = (int) (alturaAtual * zoomFactor);

        // 🔒 Limita o zoom máximo e mínimo
        if (novaLarguraZoom > larguraImagemOriginal * FATOR_ZOOM_MAX) {
          novaLarguraZoom = (int) (larguraImagemOriginal * FATOR_ZOOM_MAX);
          novaAlturaZoom = (int) (alturaImagemOriginal * FATOR_ZOOM_MAX);
        } else if (novaLarguraZoom < larguraImagemOriginal * FATOR_ZOOM_MIN) {
          novaLarguraZoom = (int) (larguraImagemOriginal * FATOR_ZOOM_MIN);
          novaAlturaZoom = (int) (alturaImagemOriginal * FATOR_ZOOM_MIN);
        }

        // 🔄 Redimensiona a imagem com o novo tamanho
        Image imagemZoomada = imagemOriginal.getImage().getScaledInstance(novaLarguraZoom, novaAlturaZoom, Image.SCALE_SMOOTH);

        // 🖼️ Atualiza o ícone da imagem com o novo tamanho
        labelImagemMaximizada.setIcon(new ImageIcon(imagemZoomada));

        // 🔧 Atualiza o painel de rolagem para focar na posição onde o mouse está
        JScrollBar scrollBarHorizontal = painelDeRolagem.getHorizontalScrollBar();
        JScrollBar scrollBarVertical = painelDeRolagem.getVerticalScrollBar();

        // 📏 Calcula a posição do scroll em relação ao ponto do mouse
        int offsetX = (int) (pontoMouse.getX() * (zoomFactor - 1));
        int offsetY = (int) (pontoMouse.getY() * (zoomFactor - 1));

        // 🔄 Move o scroll para o local correspondente ao zoom no ponto do mouse
        scrollBarHorizontal.setValue(scrollBarHorizontal.getValue() + offsetX);
        scrollBarVertical.setValue(scrollBarVertical.getValue() + offsetY);
      }
    });
  }
}