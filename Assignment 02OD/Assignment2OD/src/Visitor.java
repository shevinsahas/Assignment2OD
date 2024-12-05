public class Visitor extends Person {
    // Attributes specific to a visitor
    private String ticketType;  // The type of ticket the visitor has purchased
    private String issueDate;   // The date when the ticket was issued

    // Default constructor initializes a visitor without setting any specific attributes
    public Visitor() {
        super();  // Calls the default constructor of the Person class
    }

    // Constructor that sets the visitor's personal details along with their ticket information
    public Visitor(String name, int age, String phoneNumber, String ticketType, String issueDate) {
        super(name, age, phoneNumber);  // Initializes the inherited attributes from Person
        this.ticketType = ticketType;   // Assigns the specified ticket type to the visitor
        this.issueDate = issueDate;     // Assigns the specified issue date to the visitor's ticket
    }

    // Methods to access and modify the visitor's specific details

    // Retrieves the type of ticket the visitor has purchased
    public String getTicketType() {
        return ticketType;
    }

    // Updates the type of ticket the visitor has purchased
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    // Retrieves the date when the visitor's ticket was issued
    public String getIssueDate() {
        return issueDate;
    }

    // Updates the date when the visitor's ticket was issued
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
}
