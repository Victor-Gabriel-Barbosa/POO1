import java.util.List;
import java.util.ArrayList;
// Declarar classe DotComBust, responsável pela lógica do jogo
public class DotComBust {
  // Inserir atributos para armazenar as DotCom's
  private GameHelper helper;
  //private DotCom dotcom;
  private List<DotCom> dotcoms;
  private int count;

  private DotCom buildDotCom() {
    DotCom dotcom = new DotCom();
    List<String> l = helper.placeDotCom(3);
    dotcom.setLocationCells(l);
    System.out.printf("Dotcom %d criada em: %s\n", dotcoms.size()+1, l);
    return dotcom;
  }
  // Inserir o método para preparar o jogo, criar e nomear as DotCom's e posicionar no campo de batalha
  public void setup() {
    helper = new GameHelper();
    dotcoms = new ArrayList<DotCom>();
    dotcoms.add(buildDotCom());
    dotcoms.add(buildDotCom());
    dotcoms.add(buildDotCom());
    count = 0;
  }

  // Inserir o método para iniciar o jogo, apresentar as regras, receber as jogadas do usuário, processar e informar o resultado de cada jogada, apresentar os resultados finais
  public void start() {
    System.out.printf("\n\n== Objetivos do jogo ==\n...\n====\n\n");
    do {
      // Inserir método para verificar se a jogada e válida e, se não for, repetir a entrada informando o problema
      String jogada  = helper.getUserInput("Informe a jogada: ");
      count++;
      String result = "miss";
      DotCom hitted = null;
      for(DotCom dotcom : dotcoms) {
        result = dotcom.checkYourself(jogada);
        if (!result.equals("miss")) {
          hitted = dotcom;
          break;
        }
      }
      if (result.equals("kill")) {
        dotcoms.remove(hitted);
      }
      System.out.printf("Resultado: %s\n\n", result);    
      
    } while (!dotcoms.isEmpty());
    finishGame();
  }

// Inserir o método para apresentar os resultados do jogo  
  public void finishGame() {
    System.out.printf("Jogo terminado após %d jogadas.", count);
  }
}
