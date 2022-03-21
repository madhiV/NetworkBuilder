import java.util.*;
public class Computer extends Device{
    private int strength;
    Computer(String name){
        super(name);
        strength=5;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
