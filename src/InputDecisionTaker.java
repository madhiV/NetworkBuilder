public class InputDecisionTaker {
    public static void perform(String[] arr,Network network){
        Action action = Action.valueOf(arr[0]);
        switch(action){
            case ADD:
                addProcess(arr,network);
                break;
            case CONNECT:
                connectProcess(arr,network);
                break;
            case SET_DEVICE_STRENGTH:
                strengthInitializer(arr,arr[1],network);
                break;
            case INFO_ROUTE:
                routeCaller(arr,network);
                break;
            default:
                PrintStatements.invalidSyntax();
                break;
        }
    }
    public static void addProcess(String[] arr,Network network){
        if(arr.length!=3){
            PrintStatements.invalidSyntax();
            return;
        }
        Devices dev=Devices.valueOf(arr[1]);
        String deviceName=arr[2];
        AddInitializer.perform(dev,deviceName,network);
    }
    public static void connectProcess(String[] arr,Network network){
        if(arr.length!=3){
            PrintStatements.invalidSyntax();
            return;
        }
        network.connect(arr[1],arr[2]);
    }
    public static void strengthInitializer(String[] arr,String deviceName,Network network){
        if(!Validations.isValidForSetStrength(arr)){
            return;
        }
        network.setStrength(deviceName,Integer.parseInt(arr[2]));
    }
    public static void routeCaller(String[] arr,Network network){
        if(arr.length!=3){
            PrintStatements.invalidSyntax();
            return;
        }
        network.routeInitializer(arr[1],arr[2]);
    }
}
