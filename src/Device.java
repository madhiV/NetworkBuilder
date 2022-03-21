import java.util.*;
public class Device {
    private String name;
    List<Device> neighbors;
    public Device(String name) {
        this.name = name;
        neighbors=new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getNeighbors() {
        return neighbors;
    }
}
