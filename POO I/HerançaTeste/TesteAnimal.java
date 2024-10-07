// Classe abstrata Animal
abstract class Animal {
  // Método abstrato
  public abstract void makeSound();

  // Método concreto
  public void sleep() {
    System.out.println("The animal is sleeping");
  }
}

// Classe Dog que herda de Animal
class Dog extends Animal {
  // Implementação do método abstrato
  @Override
  public void makeSound() {
    System.out.println("Woof!");
  }
}

// Classe Cat que herda de Animal
class Cat extends Animal {
  // Implementação do método abstrato
  @Override
  public void makeSound() {
    System.out.println("Meow!");
  }
}

// Classe principal para testar herança e polimorfismo
public class TesteAnimal {
  public static void main(String[] args) {
    // Polimorfismo: Dog e Cat são do tipo Animal
    Animal myDog = new Dog();
    Animal myCat = new Cat();

    // Chamada dos métodos com polimorfismo
    myDog.makeSound(); // Output: Woof!
    myCat.makeSound(); // Output: Meow!

    // Método concreto disponível na classe abstrata
    myDog.sleep(); // Output: The animal is sleeping
    myCat.sleep(); // Output: The animal is sleeping
  }
}
