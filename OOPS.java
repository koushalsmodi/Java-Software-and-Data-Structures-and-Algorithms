class Student{
    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println(name + " " + age);
    }


}

public class OOPS{
    public static void main(String[] args){
        Student s1 = new Student("Ganesh", 24);
        

    }
}