package com.company;

public class Main {

    static interface Moveable {
        void move(float dx, float dy);
        void resize(float koeff);
    }

    static abstract class Figure implements Moveable{
        float x;
        float y;

        public Figure(float x, float y){
            this.x = x;
            this.y = y;
        }

        public abstract float getArea();
        public abstract float getPerimeter();

        void Center(){}
    }

    static class Rectangle extends Figure {
        float height;
        float width;

        public Rectangle(float x, float y, float height, float width) {
            super(x, y);
            this.height = height;
            this.width = width;
        }

        @Override
        public float getArea(){
            return this.height * this.width;
        }

        @Override
        public float getPerimeter(){
            return 2*this.width + 2*this.height;
        }

        @Override
        public void move(float dx, float dy) {
            super.x += dx;
            super.y += dy;
        }

        @Override
        public void resize(float koeff) {
            this.width *= koeff;
            this.height *= koeff;
        }

        @Override
        void Center(){
            System.out.println("Center: (" + (x + (width / 2)) + ", " + (y + (height / 2)) + ")");
        }

        @Override
        public String toString() {
            return ("Rectangle" + "\n" + "Center: " + "(" + (x + height / 2) + ", " + (y + width / 2) + ")" + "\n" + "Height: " + height + "\n" + "Width: " + width);
        }
    }

    static class Circle extends Figure {
        float radius;

        public Circle(float x, float y, float radius) {
            super(x, y);
            this.radius = radius;
        }

        @Override
        public float getArea(){
            return (float) (Math.PI*(this.radius * this.radius));
        }

        @Override
        public float getPerimeter(){
            return (float) (2*Math.PI*this.radius);
        }

        @Override
        public void move(float dx, float dy) {
            super.x += dx;
            super.y += dy;
        }

        @Override
        public void resize(float koeff) {
            this.radius *= koeff;
        }

        @Override
        void Center(){
            System.out.println("Center: (" + x + ", " + y + ")");
        }

        @Override
        public String toString() {
            return ("Circle" + "\n" + "Center: " + "(" + x + ", " + y + ")" + "\n" + "Radius: " + radius);
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(10, 10, 1);
        Rectangle rectangle = new Rectangle(10, 10, 1, 1);
        System.out.println(circle);
        System.out.println();
        System.out.println(rectangle);
    }
}
