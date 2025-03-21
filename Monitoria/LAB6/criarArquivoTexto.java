import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import javax.swing.JOptionPane;

public class criarArquivoTexto {
  private Formatter saida; // Objeto usado para enviar texto para arquivo
  private boolean arquivoAberto = false;

  // Abre arquivo "clientes.txt"
  public boolean abrirArquivo() {
    try {
      saida = new Formatter("clientes.txt");
      arquivoAberto = true;
      return true;
    } catch (SecurityException securityException) {
      JOptionPane.showMessageDialog(null, "Permissão de escrita negada.", "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (FileNotFoundException fileNotFoundException) {
      JOptionPane.showMessageDialog(null, "Erro ao criar o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  // Adiciona um registro ao arquivo
  public boolean adicionarRegistro(gravarRegistros registro) {
    if (!arquivoAberto) {
      JOptionPane.showMessageDialog(null, 
        "Erro: Arquivo não está aberto. Abra o arquivo primeiro.",
        "Arquivo Fechado", JOptionPane.WARNING_MESSAGE
      );
      return false;
    }

    try {
      // Escreve registro no arquivo
      saida.format("%d %s %.2f%n", registro.getConta(), registro.getNome(), registro.getSaldo());
      return true;
    } catch (FormatterClosedException formatterClosedException) {
      JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
      return false;
    }
  }

  // Fecha arquivo
  public boolean fecharArquivo() {
    if (arquivoAberto) {
      if (saida != null) {
        saida.close();
        arquivoAberto = false;
        return true;
      }
    }
    return false;
  }
  
  // Verifica se o arquivo está aberto
  public boolean isArquivoAberto() {
    return arquivoAberto;
  }
}