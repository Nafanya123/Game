import java.util.HashMap;
import java.util.Map;

public class Location {

    private String name;



    private String description;
    private Inventory inventory = new Inventory();
    private Map<Direction, Location> directions = new HashMap<>();

    Location(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public void putDirections(Direction direction, Location location)
    {
        directions.put(direction, location);
    }
    public void inventory()
    {
        inventory.show();
    }

    public Location nextLocation(Direction direction, Location location) {

        if(directions.containsKey(direction))
        {
            location = directions.get(direction);
            return location;
        }
        else
            System.out.println("Вы не можете туда идти.");

        return location;
    }

    public void putItem(Item item)
    {
        inventory.add(item);
    }

    public void remove(Item item)
    {
        inventory.remove(item);
    }

    public boolean find(String name)
    {
        return inventory.find(name);
    }

    public Item findItem(String name)
    {
        if(inventory.find(name))
        {
            return inventory.findItem(name);
        }
        return null;
    }
    public String getDespcription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
