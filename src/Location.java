import java.util.HashMap;
import java.util.Map;

public class Location {

    private String name;
    private String despcription;
    private Inventory inventory = new Inventory();
    public Map<Direction, Location> dl = new HashMap<Direction, Location>();

    Location(String name, String despcription)
    {
        this.name = name;
        this.despcription = despcription;
    }

    public void putItem(Item item) {
        inventory.add(item);
    }

    public String getDespcription() {
        return despcription;
    }

    public void setDespcription(String despcription) {
        this.despcription = despcription;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }
}