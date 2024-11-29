import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
import java.util.concurrent.locks.ReentrantLock;

public class Ride implements RideInterface {
    // Attributes that define a ride
    private String rideName;            // The name of the ride
    private String rideType;            // The category or type of the ride (e.g., roller coaster, ferris wheel)
    private int duration;               // The duration of the ride in minutes
    private boolean isOpen;             // Indicates whether the ride is currently operational
    private Employee operator;          // The employee responsible for operating the ride
    private Queue<Visitor> waitingQueue; // A queue that holds visitors waiting to experience the ride
    private LinkedList<Visitor> rideHistory; // A list that records visitors who have taken the ride
    private final ReentrantLock lock;   // A lock to ensure thread safety when accessing shared resources

    // Default constructor initializes the ride with default values and empty collections
    public Ride() {
        waitingQueue = new LinkedList<>(); // Initializes the waiting queue as an empty LinkedList
        rideHistory = new LinkedList<>();  // Initializes the ride history as an empty LinkedList
        lock = new ReentrantLock();        // Initializes the lock for thread safety
    }

    // Constructor that sets up the ride with specific details and initializes collections and lock
    public Ride(String rideName, String rideType, int duration, boolean isOpen, Employee operator) {
        this.rideName = rideName;           // Sets the name of the ride
        this.rideType = rideType;           // Sets the type/category of the ride
        this.duration = duration;           // Sets the duration of the ride
        this.isOpen = isOpen;               // Sets the operational status of the ride
        this.operator = operator;           // Assigns the employee who will operate the ride
        this.waitingQueue = new LinkedList<>(); // Initializes the waiting queue as an empty LinkedList
        this.rideHistory = new LinkedList<>();  // Initializes the ride history as an empty LinkedList
        this.lock = new ReentrantLock();         // Initializes the lock for thread safety
    }

    // Getters and setters
    // (No changes needed for the getters and setters)

    // Assigns an employee to operate the ride
    public void assignOperator(Employee operator) {
        this.operator = operator; // Sets the operator responsible for the ride
    }

    // Implementation of RideInterface methods

    // Adds a visitor to the waiting queue in a thread-safe manner
    public void AddVisitorToQueue(Visitor visitor) {
        lock.lock(); // Acquires the lock before modifying the waiting queue
        try {
            waitingQueue.add(visitor); // Adds the visitor to the end of the queue
            System.out.println(visitor.getName() + " added to the waiting queue.");
        } finally {
            lock.unlock(); // Releases the lock after modification
        }
    }

    // Removes a specific visitor from the waiting queue in a thread-safe manner
    public void RemoveVisitorFromQueue(Visitor visitor) {
        lock.lock(); // Acquires the lock before modifying the waiting queue
        try {
            if (waitingQueue.remove(visitor)) { // Attempts to remove the visitor from the queue
                System.out.println(visitor.getName() + " removed from the waiting queue.");
            } else {
                System.out.println(visitor.getName() + " not found in the waiting queue.");
            }
        } finally {
            lock.unlock(); // Releases the lock after modification
        }
    }

    // Displays the current waiting queue in a thread-safe manner
    public void PrintQueue() {
        lock.lock(); // Acquires the lock before accessing the waiting queue
        try {
            if (waitingQueue.isEmpty()) {
                System.out.println("Waiting queue is empty.");
            } else {
                System.out.println("Waiting queue:");
                for (Visitor visitor : waitingQueue) {
                    System.out.println(visitor.getName());
                }
            }
        } finally {
            lock.unlock(); // Releases the lock after accessing
        }
    }

    // Executes one cycle of the ride, allowing a set number of visitors to take the ride
    public void RunOneCycle() {
        lock.lock(); // Acquires the lock before modifying the waiting queue and ride history
        try {
            if (waitingQueue.isEmpty()) {
                System.out.println("No visitors in the waiting queue to run the ride.");
                return;
            }

            System.out.println("Running one cycle of the ride...");

            int maxVisitorsPerCycle = 2; // Defines the maximum number of visitors allowed per cycle
            int visitorsTaken = 0;        // Counter for the number of visitors who have taken the ride

            while (!waitingQueue.isEmpty() && visitorsTaken < maxVisitorsPerCycle) {
                Visitor visitor = waitingQueue.poll(); // Removes the visitor from the front of the queue
                rideHistory.add(visitor);              // Adds the visitor to the ride history
                System.out.println(visitor.getName() + " is taking the ride.");
                visitorsTaken++;
            }
        } finally {
            lock.unlock(); // Releases the lock after modification
        }
    }

    // Part 4A Methods

    // Adds a visitor to the ride history in a thread-safe manner
    public void AddVisitorToHistory(Visitor visitor) {
        lock.lock(); // Acquires the lock before modifying the ride history
        try {
            rideHistory.add(visitor); // Adds the visitor to the ride history
            System.out.println(visitor.getName() + " added to the ride history.");
        } finally {
            lock.unlock(); // Releases the lock after modification
        }
    }

    // Checks if a visitor is present in the ride history in a thread-safe manner
    public boolean IsVisitorInHistory(Visitor visitor) {
        lock.lock(); // Acquires the lock before accessing the ride history
        try {
            return rideHistory.contains(visitor); // Returns true if the visitor is in the history
        } finally {
            lock.unlock(); // Releases the lock after accessing
        }
    }

    // Returns the total number of visitors recorded in the ride history in a thread-safe manner
    public int NumberOfVisitorsInHistory() {
        lock.lock(); // Acquires the lock before accessing the ride history
        try {
            return rideHistory.size(); // Returns the size of the ride history
        } finally {
            lock.unlock(); // Releases the lock after accessing
        }
    }

    // Displays the ride history in a thread-safe manner
    public void PrintRideHistory() {
        lock.lock(); // Acquires the lock before accessing the ride history
        try {
            if (rideHistory.isEmpty()) {
                System.out.println("Ride history is empty.");
            } else {
                System.out.println("Ride history:");
                for (Visitor visitor : rideHistory) {
                    System.out.println(visitor.getName());
                }
            }
        } finally {
            lock.unlock(); // Releases the lock after accessing
        }
    }

    // Part 4B Method

    // Sorts the visitors in the ride history using a comparator in a thread-safe manner
    public void sortVisitors() {
        lock.lock(); // Acquires the lock before modifying the ride history
        try {
            Collections.sort(rideHistory, new VisitorComparator()); // Sorts the ride history based on custom criteria
            System.out.println("Visitors sorted.");
        } finally {
            lock.unlock(); // Releases the lock after modification
        }
    }

    // Part 6 Methods

    // Exports the ride history to a specified file in a thread-safe manner
    public void exportRideHistory(String filename) {
        lock.lock(); // Acquires the lock before accessing the ride history
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                // Writes visitor details in a comma-separated format
                writer.println(visitor.getName() + "," + visitor.getAge() + "," + visitor.getPhoneNumber() + "," + visitor.getTicketType() + "," + visitor.getIssueDate());
            }
            System.out.println("Ride history exported to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while exporting ride history: " + e.getMessage());
        } finally {
            lock.unlock(); // Releases the lock after accessing
        }
    }

    // Imports ride history from a specified file in a thread-safe manner
    public void importRideHistory(String filename) {
        lock.lock(); // Acquires the lock before modifying the ride history
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // Splits the line into individual data fields
                // Creates a new Visitor object with the imported data
                Visitor visitor = new Visitor(data[0], Integer.parseInt(data[1]), data[2], data[3], data[4]);
                rideHistory.add(visitor); // Adds the visitor to the ride history
            }
            System.out.println("Ride history imported from " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while importing ride history: " + e.getMessage());
        } finally {
            lock.unlock(); // Releases the lock after modification
        }
    }

    // Part 7 Method

    // Restores visitors from a file and adds them to the ride history in a thread-safe manner
    public void restoreVisitorsFromFile(String filename) {
        lock.lock(); // Acquires the lock before modifying the ride history
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // Splits the line into individual data fields
                // Crea
