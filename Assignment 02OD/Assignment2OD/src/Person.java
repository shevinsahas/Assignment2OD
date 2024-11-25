public abstract class Person {
    // Attributes that describe a person
    private String name;      // The person's full name
    private int age;          // The person's age in years
    private String phoneNumber;  // The person's contact phone number

    // Default constructor initializes a person without setting any attributes
    public Person() {

    }

    // To set instance variables, used a constructor with parameters.
    public Person(String name, int age, String phoneNumber) {
        this.name = name;           // Set the name
        this.age = age;             // Set the age
        this.phoneNumber = phoneNumber; // Set the phone number
    }

    // Methods to access and modify the person's details

    // Retrieves the person's name
    public String getName() {
        return name;
    }

    // Updates the person's name
    public void setName(String name) {
        this.name = name;
    }

    // Retrieves the person's age
    public int getAge() {
        return age;
    }

    // Updates the person's age
    public void setAge(int age) {
        this.age = age;
    }

    // Retrieves the person's phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Updates the person's phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
