package com.company;

public class Main {

    public static interface Moveable {
        void move(float dx, float dy);
        void resize(float koeff);
    }

    public static abstract class Figure implements Moveable{
        private float x;
        private float y;

        public Figure(float x, float y){
            this.x = x;
            this.y = y;
        }

        public abstract float getArea();
        public abstract float getPerimeter();
        
        
    }

    public static class Rectangle extends Figure {
        private float height;
        private float width;

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
    }

    public static class Circle extends Figure {
        private float radius;

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
    }

    public static void main(String[] args) {
        Circle circle = new Circle(10, 10, 1);
        Rectangle rectangle = new Rectangle(10, 10, 1, 1);
        System.out.println(circle.getArea());
        System.out.println(rectangle.getPerimeter());
    }
}
