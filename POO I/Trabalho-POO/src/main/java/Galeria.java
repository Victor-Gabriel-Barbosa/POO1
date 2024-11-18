import java.io.File; // 📦 Importa classes necessárias para manipulação de arquivos e serialização
import java.io.FileInputStream; // 📦 Importa a classe ArrayList para manipulação de listas dinâmicas
import java.io.IOException; // 📦 Importa a interface List para representar listas
import java.io.ObjectInputStream; // 📦 Importa Collectors para operações de stream (filtragem, coleta)
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Galeria { // 🖼️ Classe que representa uma galeria de artes
  private List<Arte> artes; // 🖼️ Lista que armazena as artes na galeria

  // 🖼️ Construtor da classe Galeria, que inicializa a lista de artes e carrega as artes do arquivo
  public Galeria() {
    this.artes = new ArrayList<>(); // 📝 Inicializa a lista de artes
    inicializarArtes();
    artes.addAll(carregarArtesDeArquivo("galeria.ser")); // 🗂️ Carrega as artes do arquivo .ser
  }

  // 🖼️ Método para adicionar uma nova arte à galeria
  public void adicionarArte(Arte arte) {
    if (arte != null && !artes.contains(arte)) { // ✔️ Verifica se a arte não é nula e não está duplicada
      artes.add(arte); // ➕ Adiciona a arte à lista
    } else {
      System.out.println("Arte inválida ou já existente."); // ❌ Informa que a arte é inválida ou já existe
    }
  }

  // 🖼️ Método para obter todas as artes da galeria
  public List<Arte> getArtes() {
    return artes; // 🔄 Retorna a lista de artes
  }

  // 🎨 Método para filtrar as artes pela categoria
  public List<Arte> getArtesPorCategoria(String categoria) {
    return artes.stream() // 🎯 Inicia o fluxo de artes
      .filter(arte -> arte.getCategoria().equalsIgnoreCase(categoria)) // 🔍 Filtra pela categoria
      .collect(Collectors.toList()); // 📝 Coleta as artes filtradas em uma lista
  }

  // 🗑️ Método para remover uma arte da galeria
  public void removerArte(Arte arte) {
    if (arte != null && artes.contains(arte)) { // ✔️ Verifica se a arte não é nula e está na galeria
      artes.remove(arte); // ➖ Remove a arte da lista
    } else {
      System.out.println("Arte não encontrada."); // ❌ Informa que a arte não foi encontrada
    }
  }

  // 🖼️ Método privado que inicializa a galeria com algumas artes de exemplo
  private void inicializarArtes() {
    // 🎨 Exemplo de artes a serem adicionadas à galeria
    adicionarArte(new Arte("Catedral de Notre-Dame de Reims, França", "Eugène Viollet-le-Duc", "Dedicada à Virgem Maria, a Catedral de Notre Dame é uma das catedrais góticas mais antigas do mundo", "C:\\Users\\usuario\\Desktop\\Programas\\POO_1\\POO I\\Trabalho-POO\\src\\main\\java\\recursos\\gotico_imagens\\acapa-1.png", "Gótica"));
    adicionarArte(new Arte("F. Champenois Imprimeur-Éditeur", "Alfons Mucha", "“Champenois” é uma das obras mais conhecidas do artista tcheco Alphonse Mucha, um dos principais representantes do movimento Art Nouveau. Mucha era conhecido por suas pinturas, cartazes e ilustrações que celebravam a beleza feminina, o esplendor da natureza e a estética ornamental.", "C:\\Users\\usuario\\Desktop\\Programas\\POO_1\\POO I\\Trabalho-POO\\src\\main\\java\\recursos\\n" + //
            "ouveau_imagens\\artnouveau-capa.png", "Nouveau"));
  }

  private List<Arte> carregarArtesDeArquivo(String caminhoArquivo) {
    List<Arte> artes = new ArrayList<>();
    File arquivo = new File(caminhoArquivo);

    // Verifica se o arquivo existe e não está vazio
    if (!arquivo.exists() || arquivo.length() == 0) {
      System.out.println("Arquivo vazio ou inexistente.");
      return artes;
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
      Object obj = ois.readObject();

      // Verifica se o objeto lido é uma instância de List
      if (obj instanceof List<?>) {
        List<?> tempList = (List<?>) obj;

        // Verifica se todos os elementos da lista são do tipo Arte
        if (!tempList.isEmpty() && tempList.stream().allMatch(element -> element instanceof Arte)) {
          artes = tempList.stream()
                  .map(element -> (Arte) element)
                  .collect(Collectors.toList());
          System.out.println("Artes carregadas com sucesso.");
        } 
      } else {
        System.out.println("Erro: O arquivo não contém uma lista válida.");
      }
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Erro ao carregar artes do arquivo: " + e.getMessage());
      e.printStackTrace();
    } catch (ClassCastException e) {
      System.out.println("Erro ao fazer o cast do objeto para List<Arte>: " + e.getMessage());
      e.printStackTrace();
    }
    return artes;
  }
}