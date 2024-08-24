abstract class Animal{
    abstract void walk();
    void breathe(){
        System.out.println("this animal breathes air");
    }
    Animal(){
        System.out.println("creating an animal");
    }

}

class Horse extends Animal{
    Horse(){
        System.out.println("created a horse");
    }
    void walk(){
        System.out.println("has four 4 legs");
    }
}

public class OOPS{
    public static void main(String[] args){
        Horse horse = new Horse();
        horse.walk();
        horse.breathe();

    }
}