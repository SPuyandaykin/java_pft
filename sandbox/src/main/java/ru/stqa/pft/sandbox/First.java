package ru.stqa.pft.sandbox;

import java.io.*;

public class First {
    public static void main (String[] args){

        try {
            File file = new File("C:\\Tools\\note.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

/*
        hello("World");
        hello("user");
        hello("Sergey");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами" + r.a + " и " + r.b + " = " + r.area());
 */
    }

    public static void hello (String somebody){
        System.out.println("Hello, " + somebody + "!");
    }
}
