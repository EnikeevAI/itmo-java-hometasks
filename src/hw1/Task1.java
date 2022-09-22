package hw1;

// Даны длина, ширина и высота прямоугольного параллелепипеда. Найти и вывести в консоль его площадь.
public class Task1 {
    public static class Parallelepiped {

        public double getArea(double length, double width, double height){
            return  2 * (length * width + length * height + width * height);
        }
    }

    public static void main(String[] args) {
        double length = 5.0, width = 10.0, height = 15.0;

        Parallelepiped parallelepiped = new Parallelepiped();

        System.out.print("Area is ");
        System.out.println(parallelepiped.getArea(length, width, height));
    }
}
