class Pen{
    String colour; // red, green, blue, yellow
    String type; // ballpoint, gel

    public void write(){
        System.out.println("writing something");
    }

    public void printColor(){
        System.out.println(this.colour);
    }
}

class Student{

    String name;
    int age;

    public void printInfo(String name){
        System.out.println(this.name);
        
    }

    public void printInfo(int age){
        System.out.println(this.age);

    }

    public void printInfo(String name, int age){
        System.out.println(name + " " + age);
    }
}

public class OOPS {
    public static void main(String[] args){
        Student s1 = new Student();
        s1.name = "Ganpati";
        s1.age = 24;

        s1.printInfo(s1.name, s1.age);

        

    }
}
