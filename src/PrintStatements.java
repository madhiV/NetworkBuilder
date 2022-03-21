public class PrintStatements {
    public static void invalidSyntax(){
        System.out.println("Invalid command syntax.");
    }
    public static void nodeNotFound(){
        System.out.println("Node not found.");
    }
    public static void cannotConnectItself(){
        System.out.println("Error: Cannot cannot device to itself.");
    }
    public static void alreadyConnected(){
        System.out.println("Error: Devices are already connected.");
    }
    public static void successfulConnection(){
        System.out.println("Successfully connected.");
    }
    public static void alreadyExists(){
        System.out.println("That name already exists.");
    }
    public static void successfullyAdded(String deviceName){
        System.out.println("Successfully added "+deviceName+".");
    }
    public static void successfullyDefinedStrength(){
        System.out.println("Successfully defined strength.");
    }
    public static void printRepeaterStrength(){
        System.out.println("Cannot set strength for a repeater.");
    }
    public static void print(String s){
        System.out.println(s);
    }
    public static void routeNotFound(){
        System.out.println("Route not found!");
    }
    public static void printRouteRepeater(){
        System.out.println("Route cannot be calculated with a repeater");
    }
}
