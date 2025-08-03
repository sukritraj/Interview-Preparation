package com.example.design.creational.factory;

public class Main {
    public static void main(String[] args) {
        ShapeInstanceFactory shapeInstanceFactory = new ShapeInstanceFactory();
        Shape circle = shapeInstanceFactory.getShapeInstance("CIRCLE");
        circle.computeArea();
        Shape square = shapeInstanceFactory.getShapeInstance("SQUARE");
        square.computeArea();
    }
}
