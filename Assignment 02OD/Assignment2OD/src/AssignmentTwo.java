
public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    /**
     * Part 3:
     * Demonstrates creating employees, rides, and visitors.
     * Adds visitors to a ride's waiting queue, removes a visitor, and prints the current queue.
     */
    public void partThree() {
        // Create an Employee object who will operate the ride
        Employee operator = new Employee("Kapila Manitha", 35, "0498347634", "Evening", "Operator");

        // Instantiate a new Ride object with specific details
        Ride rollerCoaster = new Ride("BATWING Spaceshot", "Thrill", 10, true, operator);

        // Create multiple Visitor objects with their respective details
        Visitor visitor1 = new Visitor("Nethmi", 20, "0412345679", "Regular", "2024-12-01");
        Visitor visitor2 = new Visitor("Sandavi", 22, "0417454666", "Regular", "2024-12-01");
        Visitor visitor3 = new Visitor("Senavirathne", 28, "04453443453", "VIP", "2024-12-01");
        Visitor visitor4 = new Visitor("Wickramasinghe", 21, "044545333", "Regular", "2023-12-01");
        Visitor visitor5 = new Visitor("Thilakarathne", 25, "0499999997", "VIP", "2024-12-01");

        // Add the created visitors to the roller coaster's waiting queue
        rollerCoaster.AddVisitorToQueue(visitor1);
        rollerCoaster.AddVisitorToQueue(visitor2);
        rollerCoaster.AddVisitorToQueue(visitor3);
        rollerCoaster.AddVisitorToQueue(visitor4);
        rollerCoaster.AddVisitorToQueue(visitor5);

        System.out.println("\nRemoving a visitor from the queue:");
        // Remove a specific visitor (visitor3) from the waiting queue
        rollerCoaster.RemoveVisitorFromQueue(visitor3);

        System.out.println("\nPrinting all visitors in the queue:");
        // Display the current list of visitors waiting in the queue
        rollerCoaster.PrintQueue();

        System.out.println("=== End of Part 3 ===\n");
    }

    /**
     * Part 4A:
     * Demonstrates adding visitors to a ride's history and running a ride cycle.
     * After running a cycle, it prints the ride history to show which visitors have taken the ride.
     */
    public void partFourA() {
        // Create a new Employee object who will operate the new ride
        Employee newOperator = new Employee("John Don", 30, "0454353433", "Evening", "Operator");

        // Instantiate a new Ride object with specific details (e.g., "Batwing Spaceshot")
        Ride batwingSpaceshot = new Ride("Star Parade", "Thrill", 3, true, newOperator);

        // Create multiple Visitor objects with their respective details
        Visitor visitor6 = new Visitor("Tom shellby", 24, "0413456789", "Regular", "2024-12-01");
        Visitor visitor7 = new Visitor("AKD", 27, "0413423423", "VIP", "2024-12-01");
        Visitor visitor8 = new Visitor("Ben 10", 22, "041334343", "Regular", "2024-12-01");
        Visitor visitor9 = new Visitor("Tritha", 29, "04134222111", "Regular", "2024-12-01");
        Visitor visitor10 = new Visitor("Leo", 31, "04138322323", "VIP", "2024-12-01");

        // Add the created visitors to the batwingSpaceshot's waiting queue
        batwingSpaceshot.AddVisitorToQueue(visitor6);
        batwingSpaceshot.AddVisitorToQueue(visitor7);
        batwingSpaceshot.AddVisitorToQueue(visitor8);
        batwingSpaceshot.AddVisitorToQueue(visitor9);
        batwingSpaceshot.AddVisitorToQueue(visitor10);

        System.out.println("\nRunning one cycle of the ride:");
        // Execute one cycle of the ride, allowing a set number of visitors to take the ride
        batwingSpaceshot.RunOneCycle();

        System.out.println("\nPrinting the ride history:");
        // Display the history of visitors who have taken the ride
        batwingSpaceshot.PrintRideHistory();

        System.out.println("=== End of Part 4A ===\n");
    }

    /**
     * Part 4B:
     * Demonstrates sorting the ride history based on visitor names and ages.
     * Prints the ride history before and after sorting to show the effect.
     */
    public void partFourB(){
        System.out.println("=== Part 4B: Sorting the collection ===");

        // Create a new Employee object who will operate the new ride
        Employee newOperator = new Employee("Alice wonderland", 32, "0417865470", "Morning", "Operator");

        // Instantiate a new Ride object with specific details (e.g., "Green Lantern Coaster")
        Ride greenLanternCoaster = new Ride("Green Lantern Coaster", "Thrill", 4, true, newOperator);

        // Create multiple Visitor objects with their respective details
        Visitor visitor11 = new Visitor("Suneetha", 24, "0413456789", "Regular", "2024-12-01");
        Visitor visitor12 = new Visitor("Peris Anna", 28, "04135343890", "VIP", "2024-12-01");
        Visitor visitor13 = new Visitor("Brian Bruce", 26, "04136234901", "Regular", "2024-12-01");
        Visitor visitor14 = new Visitor("Bat", 21, "0413709812", "Regular", "2024-12-01");
        Visitor visitor15 = new Visitor("Zoe", 32, "0413890923", "VIP", "2024-12-01");

        // Add the created visitors to the greenLanternCoaster's ride history
        greenLanternCoaster.AddVisitorToHistory(visitor11);
        greenLanternCoaster.AddVisitorToHistory(visitor12);
        greenLanternCoaster.AddVisitorToHistory(visitor13);
        greenLanternCoaster.AddVisitorToHistory(visitor14);
        greenLanternCoaster.AddVisitorToHistory(visitor15);

        System.out.println("\nPrinting all visitors in the collection before sorting:");
        // Display the current ride history before sorting
        greenLanternCoaster.PrintRideHistory();

        System.out.println("\nSorting the collection:");
        // Sort the ride history based on visitor names and ages using VisitorComparator
        greenLanternCoaster.sortVisitors();

        System.out.println("\nPrinting all visitors in the collection after sorting:");
        // Display the ride history after sorting to show the updated order
        greenLanternCoaster.PrintRideHistory();

        System.out.println("=== End of Part 4B ===\n");
    }

    /**
     * Part 5:
     * Demonstrates exporting ride history to a file and importing it back.
     * After importing, it prints the ride history to confirm successful import.
     */
    public void partFive(){
        // Create a new Ride object with a designated operator
        Employee operator = new Employee("Hirusha Heenkenda", 21, "0401111110", "Morning", "Operator");
        Ride greenLanternCoaster = new Ride("Justice League 3D The Ride", "Roller Coaster", 5, true, operator);

        // Create multiple Visitor objects with their respective details
        Visitor visitor1 = new Visitor("Mark", 25, "0401000000", "Regular", "01-08-2024");
        Visitor visitor2 = new Visitor("Anna", 28, "0402000000", "VIP", "01-08-2024");
        Visitor visitor3 = new Visitor("Brian", 22, "0403000000", "Regular", "01-08-2024");
        Visitor visitor4 = new Visitor("Lucy", 30, "0404000000", "Regular", "01-08-2024");
        Visitor visitor5 = new Visitor("Zoe", 26, "0405000000", "VIP", "01-08-2024");

        // Add the created visitors to the greenLanternCoaster's ride history
        greenLanternCoaster.AddVisitorToHistory(visitor1);
        greenLanternCoaster.AddVisitorToHistory(visitor2);
        greenLanternCoaster.AddVisitorToHistory(visitor3);
        greenLanternCoaster.AddVisitorToHistory(visitor4);
        greenLanternCoaster.AddVisitorToHistory(visitor5);

        // Define the filename for exporting the ride history
        String filename = "rideHistory.csv";
        // Export the current ride history to the specified file
        greenLanternCoaster.exportRideHistory(filename);

        // Clear the existing ride history to simulate a fresh state
        greenLanternCoaster.clearRideHistory();

        // Import the ride history from the previously exported file
        greenLanternCoaster.importRideHistory(filename);

        // Display the imported ride history to confirm successful import
        greenLanternCoaster.PrintRideHistory();
    }

    /**
     * Part 6:
     * Demonstrates writing visitor data to a file.
     * Exports the ride history to a CSV file.
     */
    public void partSix(){
        System.out.println("=== Part 6: Writing to a file ===");

        // Create a new Employee object who will operate the ride
        Employee operator = new Employee("Alice Brown", 32, "0412345670", "Morning", "Operator");

        // Instantiate a new Ride object with specific details (e.g., "Green Lantern Coaster")
        Ride greenLanternCoaster = new Ride("Green Lantern Coaster", "Thrill", 4, true, operator);

        // Create multiple Visitor objects with their respective details
        Visitor visitor1 = new Visitor("Nethmi", 20, "0412345679", "Regular", "2024-12-01");
        Visitor visitor2 = new Visitor("Sandavi", 22, "0417454666", "Regular", "2024-12-01");
        Visitor visitor3 = new Visitor("Senavirathne", 28, "04453443453", "VIP", "2024-12-01");
        Visitor visitor4 = new Visitor("Wickramasinghe", 21, "044545333", "Regular", "2023-12-01");
        Visitor visitor5 = new Visitor("Thilakarathne", 25, "0499999997", "VIP", "2024-12-01");


        // Add the created visitors to the greenLanternCoaster's ride history
        greenLanternCoaster.AddVisitorToHistory(visitor1);
        greenLanternCoaster.AddVisitorToHistory(visitor2);
        greenLanternCoaster.AddVisitorToHistory(visitor3);
        greenLanternCoaster.AddVisitorToHistory(visitor4);
        greenLanternCoaster.AddVisitorToHistory(visitor5);

        // Export the current ride history to a CSV file named "rideHistory.csv"
        greenLanternCoaster.exportRideHistory("rideHistory.csv");

        System.out.println("=== End of Part 6 ===");
    }

    /**
     * Part 7:
     * Demonstrates restoring visitors from a file into a ride's history.
     * After restoration, it prints the number of visitors and their details to confirm accuracy.
     */
    public void partSeven(){
        System.out.println("=== Part 7: Restoring Visitors from a file ===");

        // Create a new Employee object who will operate the new ride
        Employee newOperator = new Employee("Emily White", 29, "0412987654", "Afternoon", "Operator");

        // Instantiate a new Ride object with specific details (e.g., "Wild West Falls")
        Ride wildWestFalls = new Ride("Wild West Falls", "Water", 7, true, newOperator);

        // Import visitors from the previously exported "rideHistory.csv" file into the ride's history
        wildWestFalls.restoreVisitorsFromFile("rideHistory.csv");

        // Display the total number of visitors imported into the ride's history
        System.out.println("Number of visitors in the ride history: " + wildWestFalls.NumberOfVisitorsInHistory());

        // Display all visitors in the ride's history to confirm that their details were imported correctly
        wildWestFalls.PrintRideHistory();

        System.out.println("=== End of Part 7 ===");
    }
}
