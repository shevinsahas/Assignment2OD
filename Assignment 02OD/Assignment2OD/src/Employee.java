public class Employee extends Person {
    //Attributes specific to an employee
    private String shift; //work shift assigned to the employee
    private String role; // The job role of the employee

    //Default constructor initializes an employee without setting any specific attributes
    public Employee(){
        super(); //calls the default constructor of the Person class
    }

    // Constructor that sets the employee's personal details along with their shift and role
    public Employee(String name, int age, String phoneNumber, String shift, String role) {
        super(name, age, phoneNumber); //intializes the inherited attributes from Person
        this.shift = shift; //Assigns the specified work shift to the employee
        this.role = role;  // Assigns the specified role to the employee
    }

    //methods to acess and modify the employee's work shift

    //retrieves the employee's work shift
     public String getShift() {
        return shift;
    }

    // Updates the employee's work shift
    public void setShift(String shift) {
        this.shift = shift;
    }

    // Retrieves the employee's role within the organization
    public String getRole() {
        return role;
    }

    // Updates the employee's role within the organization
    public void setRole(String role) {
        this.role = role;
    }
}