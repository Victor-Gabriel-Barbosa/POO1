import java.util.List;
// Definir classe DotCom
public class DotCom {
  private List<String> locationCells;
  
  public void setLocationCells(List<String> cells) {
    this.locationCells = cells; 
  }

  public String checkYourself(String guess) {
    String result = "miss";
    for(String p : locationCells) {
      if (p.equals(guess)) {
        result = "hit";
        break;
      }
    }
    if (result == "hit") {
      locationCells.remove(guess);
    }
    if (locationCells.isEmpty()) {
      result = "kill";
    }
    return result;
  }
}
// Inserir atributos que permitam localizar e nomear uma DotCom
// Inserir métodos de acesso e alteração dos atributos
// Atentar para os modificadores de visibilidade
