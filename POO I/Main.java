/* 
* 9.8 (Hierarquia de herança Quadrilateral) Escreva uma hierarquia de herança para as classes
* Quadrilateral, Trapezoid, Parallelogram, Rectangle e Square. Utilize Quadrilateral como
* a superclasse da hierarquia. Crie e use uma classe Point para representar os pontos em cada forma.
* Faça a hierarquia o mais profunda possível (isto é, com muitos níveis). Especifique as variáveis
* de instância e os métodos para cada classe. As variáveis de instância private de Quadrilateral
* devem ser os pares de coordenadas x-y para os quatro pontos que delimitam o Quadrilateral.
* Escreva um programa que instancia objetos de suas classes e gera saída da área de cada objeto
* (exceto Quadrilateral) 
*/

class Point {
  private double x;
  private double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }
}

abstract class Quadrilateral {
  private Point p1, p2, p3, p4;

  public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.p4 = p4;
  }

  public Point getP1() {
    return p1;
  }

  public Point getP2() {
    return p2;
  }

  public Point getP3() {
    return p3;
  }

  public Point getP4() {
    return p4;
  }

  public abstract double getArea();
}

class Trapezoid extends Quadrilateral {
  public Trapezoid(Point p1, Point p2, Point p3, Point p4) {
    super(p1, p2, p3, p4);
  }

  @Override
  public double getArea() {
    double a = Math.sqrt(Math.pow(getP1().getX() - getP2().getX(), 2) + Math.pow(getP1().getY() - getP2().getY(), 2));
    double b = Math.sqrt(Math.pow(getP3().getX() - getP4().getX(), 2) + Math.pow(getP3().getY() - getP4().getY(), 2));
    double h = Math.sqrt(Math.pow(getP1().getX() - getP3().getX(), 2) + Math.pow(getP1().getY() - getP3().getY(), 2));
    return (a + b) * h / 2;
  }
}

class Parallelogram extends Quadrilateral {
  public Parallelogram(Point p1, Point p2, Point p3, Point p4) {
    super(p1, p2, p3, p4);
  }

  @Override
  public double getArea() {
    double a = Math.sqrt(Math.pow(getP1().getX() - getP2().getX(), 2) + Math.pow(getP1().getY() - getP2().getY(), 2));
    double h = Math.abs(getP1().getY() - getP3().getY());
    return a * h;
  }
}

class Rectangle extends Parallelogram {
  public Rectangle(Point p1, Point p2, Point p3, Point p4) {
    super(p1, p2, p3, p4);
  }
}

class Square extends Rectangle {
  public Square(Point p1, Point p2, Point p3, Point p4) {
    super(p1, p2, p3, p4);
  }
}

public class Main {
  public static void main(String[] args) {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 3);
    Point p3 = new Point(4, 0);
    Point p4 = new Point(4, 3);

    Trapezoid trapezoid = new Trapezoid(p1, p2, p3, p4);
    System.out.println("Trapezoid Area: " + trapezoid.getArea());

    Parallelogram parallelogram = new Parallelogram(p1, p2, p3, p4);
    System.out.println("Parallelogram Area: " + parallelogram.getArea());

    Rectangle rectangle = new Rectangle(p1, p2, p3, p4);
    System.out.println("Rectangle Area: " + rectangle.getArea());

    Square square = new Square(p1, p2, p3, p4);
    System.out.println("Square Area: " + square.getArea());
  }
}
