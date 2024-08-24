class Pen{
    String brand;
    String colour;
    String type;

    public void printInfo(){
        System.out.println("Brand name: "+ this.brand);
        System.out.println("Colour: " + this.colour);
        System.out.println("Type: " + this.type);
        System.out.println();
    }

}

public class OOPS{
    public static void main(String[] args){
        Pen pen1 = new Pen();
        pen1.brand = "Pilot";
        pen1.colour = "Blue";
        pen1.type = "gel";

        Pen pen2 = new Pen();
        pen2.brand = "Microsoft";
        pen2.colour = "yellow";
        pen2.colour = "ball";

        Pen pen3 = new Pen();
        pen3.brand = "Amazon";
        pen3.colour = "red";
        pen3.type = "balloon";

        pen1.printInfo();
        pen2.printInfo();
        pen3.printInfo();

    }
}