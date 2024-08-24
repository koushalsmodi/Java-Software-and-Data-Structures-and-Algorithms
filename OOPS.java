class Student{
    String name;
    int age;


    public void printInfo(String name){
        System.out.println("Name: " + name);
    }

    public void printInfo(int age){
        System.out.println("Age: " + age);
    }

    public void printInfo(String name, int age){
        System.out.println("Name: " + name + " Age: " + age);
    }

}

public class OOPS{
    public static void main(String[] args){
        Student s1 = new Student();
        s1.printInfo("Jason");
        s1.printInfo("Ganpati", 24);
        s1.printInfo(19);


    }
}