package org.example.test0710.자바OOP구현문제;

abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    double b;

    Circle(int a) {
        this.b = Math.pow(a, 2);
    }

    @Override
    double getArea() {
        return 3.14 * this.b;
    }
}

class Rectangle extends Shape {
    int a;
    int b;
    int result;

    Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
        this.result = a * b;
    }

    @Override
    double getArea() {
        return a * b;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        System.out.println(circle.getArea());

        Rectangle rectangle = new Rectangle(10, 20);
        System.out.println(rectangle.getArea());

    }
}
