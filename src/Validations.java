import java.util.*;
public class Validations {
    public static boolean isValidForSetStrength(String[] arr){
        if(arr.length!=3){
            return false;
        }
        if(!isNumber(arr[2])){
            PrintStatements.invalidSyntax();
            return false;
        }
        return true;
    }
    public static boolean isNumber(String s){
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static boolean validateRoute(int ind1,int ind2,List<Device> l){
        if(ind1==-1 || ind2==-1){
            PrintStatements.nodeNotFound();
            return false;
        }
        if(!isComputer(l.get(ind1)) || !isComputer(l.get(ind2))){
            PrintStatements.printRouteRepeater();
            return false;
        }
        return true;
    }
    public static boolean isComputer(Device d){
        return d instanceof Computer;
    }
}
