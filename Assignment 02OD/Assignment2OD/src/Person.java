public abstract class Person {
    private String name;
    private int age;
    private String phoneNumber;

    public Person(){

    }

    public person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age  = age;
        this.phoneNumber = phoneNumber;
    }

    public String getname(){
        return name;
    }
     
}