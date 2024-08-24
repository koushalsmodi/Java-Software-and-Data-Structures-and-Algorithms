class Student{
    String name;
    int age;

    public void printInfo(){
        this.name = name;
        this.age = age;
        System.out.println(name + " " + age);

    }

}

public class OOPS{
    public static void main(String[] args){
        Student student1 = new Student();
        student1.name = "Avi";
        student1.age = 24;
        student1.printInfo();

        Student student2 = new Student();
        student2.name = "kumar";
        student2.age = 19;
        student2.printInfo();

    }
}