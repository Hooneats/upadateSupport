package com.example.temptest;

public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.ccc();

//        System.out.println(car instanceof Car);
//        System.out.println(car instanceof Nar);
//        System.out.println(car instanceof Par);
//        Nar par = (Nar) car;
//
//        par.xxx();
//        par.ccc();

        System.out.println(Math.round(3.5));
    }

    static class Car {

        public void ccc() {
            System.out.println("Car gogo");
        }
    }

    static class Par extends Car {

        public void ccc() {
            System.out.println("Par gogo");
        }
    }

    static class Nar extends Car {

        public void ccc() {
            System.out.println("Nar gogo");
        }

        public void xxx() {
            System.out.println("Nar xxx");
        }
    }

}
