import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;
public class Network {
    private List<Device> devices;
    public static int min;
    public static String route;
    Network(){
        devices=new LinkedList<>();
    }

    public List<Device> getDevices() {
        return devices;
    }


    public int getDeviceIndex(String deviceName){
        //Checking in device list...
        for(int i=0;i<devices.size();i++){
            if(devices.get(i).getName().equals(deviceName)){
                return i;
            }
        }
        return -1;
    }


    public void addComputer(String computerName){
        if(getDeviceIndex(computerName)!=-1){
            PrintStatements.alreadyExists();
        }
        else{
            Device d;
            d=new Computer(computerName);
            devices.add(d);
            PrintStatements.successfullyAdded(computerName);
        }
    }

    public void addRepeater(String repeaterName){
        if(getDeviceIndex(repeaterName)!=-1){
            PrintStatements.alreadyExists();
        }
        else{
            Device d;
            d=new Computer(repeaterName);
            devices.add(d);
            PrintStatements.successfullyAdded(repeaterName);
        }
    }

    public void connect(String d1,String d2){
        if(getDeviceIndex(d1)==-1 || getDeviceIndex(d2)==-1){
            PrintStatements.nodeNotFound();
            return;
        }
        Device device1,device2;
        device1=devices.get(getDeviceIndex(d1));
        device2=devices.get(getDeviceIndex(d2));
        connectDevices(device1,device2);
    }

    private void connectDevices(Device device1,Device device2){
        if(device1==device2){
            PrintStatements.cannotConnectItself();
            return;
        }
        if(alreadyConnected(device1,device2)){
            PrintStatements.alreadyConnected();
            return;
        }
        device1.getNeighbors().add(device2);
        device2.getNeighbors().add(device1);
        PrintStatements.successfulConnection();
    }

    private boolean alreadyConnected(Device d1,Device d2){
        List<Device> l=d1.getNeighbors();
        for(int i=0;i<l.size();i++){
            if(l.get(i)==d2){
                return true;
            }
        }
        return false;
    }

    public void setStrength(String deviceName,int strength){
        if(getDeviceIndex(deviceName)==-1 || getDeviceIndex(deviceName)==-1){
            PrintStatements.nodeNotFound();
            return;
        }
        Device d=devices.get(getDeviceIndex(deviceName));
        Computer c;
        if(d instanceof Computer){
            c=(Computer)d;
            c.setStrength(strength);
            PrintStatements.successfullyDefinedStrength();
        }
        else{
            PrintStatements.printRepeaterStrength();
        }
    }

    public void routeInitializer(String d1,String d2){
        int ind1,ind2;
        Computer device1,device2;
        StringBuilder sb=new StringBuilder("");
        ind1=getDeviceIndex(d1);
        ind2=getDeviceIndex(d2);
        if(!Validations.validateRoute(ind1,ind2,devices)) {
            return;
        }
        device1=(Computer)devices.get(ind1);
        device2=(Computer)devices.get(ind2);
        if(device1==device2){
            System.out.println(device1.getName()+" -> "+device2.getName());
            return;
        }
        min=Integer.MAX_VALUE;
        findRoute(new HashSet<>(),new LinkedList<>(),device1,device2,device1.getStrength(),0);
        if(min==Integer.MAX_VALUE){
            PrintStatements.routeNotFound();
        }
        else{
            System.out.println(route);
        }
    }

    public void findRoute(Set<Device> visited,List<String> pathDevices,Device source,Device dest,int strength,int distance){
        visited.add(source);
        pathDevices.add(source.getName());
        if(dest==source){
            storeRoute(distance,pathDevices);
            visited.remove(source);
            pathDevices.remove(pathDevices.size()-1);
            return;
        }
        for(Device d:source.getNeighbors()){
            if(!visited.contains(d)){
                if(Validations.isComputer(d)){
                    findRoute(visited,pathDevices,d,dest,strength-1,distance+1);
                }
                else{
                    findRoute(visited,pathDevices,d,dest,strength*2,distance+1);
                }
            }
        }
        visited.remove(source);
        pathDevices.remove(pathDevices.size()-1);
    }

    public void storeRoute(int distance,List<String> pathDevices){
        if(min<distance){
            return;
        }
        StringBuilder sb=new StringBuilder("");
        min=distance;
        for(int i=0;i<pathDevices.size();i++){
            if(i== pathDevices.size()-1){
                sb.append(pathDevices.get(i));
                break;
            }
            sb.append(pathDevices.get(i)+" -> ");
        }
        route=sb.toString();
    }
}