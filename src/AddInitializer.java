public class AddInitializer {
    public static void perform(Devices dev,String deviceName,Network network){
        switch(dev){
            case COMPUTER:
                network.addComputer(deviceName);
                break;
            case REPEATER:
                network.addRepeater(deviceName);
                break;
            default:
                PrintStatements.invalidSyntax();
        }
    }
}

