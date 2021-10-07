package com.accenture.atc.javacore.m05oopbasics;


/**
 * реализуйте программа в которой есть основной класс FigureFirstStep ( имеет метод draw,  поля x,y) + toString()
 * при этом имеееются три дочерних класса  - circle, rectangle,triangle
 * в каждом дочернем классе создать по два объекта и сравнить  их.
 */
public class FigureFirstStep {
    public double x;
    public double y;

    public FigureFirstStep() {
        this.x =0.0;
        this.y =0.0;
        System.out.println("Hello from FigureFirstStep");
    }

    public FigureFirstStep(double x, double y) {
        this.x =x;
        this.y =y;
        System.out.println("Hello from FigureFirstStep");
    }

    public String toString() {
        return "Hello from FigureFirstStep";
    }
}

class Circle extends FigureFirstStep {
    public double r;

    public String toString() {
        return "Hello from Circle";
    }

    public double area() {
        return Math.PI *this.r*this.r;
    }
}

class Triangle extends FigureFirstStep {
    public double[] points;

    public String toString() {
        return "Hello from Triangle";
    }

    public double area() {
        return 0.0;
    }
}

class Rectangle extends FigureFirstStep {
    public double width;
    public double height;

    public String toString() {
        return "Hello from Rectangle";
    }

    public double area() {
        return this.width*this.height;
    }
}