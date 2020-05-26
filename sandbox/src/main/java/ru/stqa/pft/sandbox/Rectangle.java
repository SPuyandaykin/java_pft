package ru.stqa.pft.sandbox;

public class Rectangle {
    public double a;
    public double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return this.a * this.b;
    }

    public static class First {

        public static void main (String[] args) {
             hello("world");
             hello("user");
             hello("Alexei");

             Square s = new Square(5);
             System.out.println("Площадь со стороной " + s.l + " - " + s.area());

             Rectangle r = new Rectangle(4, 6);
             System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
        }

        public static void hello (String somebody){
            System.out.println("Hello, " +somebody + "!");
        }
    }
}
