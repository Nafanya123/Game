import java.util.HashMap;
import java.util.Map;

public class Location {

    private String name;
    private String despcription;
    private Inventory inventory = new Inventory();
    private Map<Direction, Location> way = new HashMap<Direction, Location>();

    Location(String name, String despcription)
    {
        this.name = name;
        this.despcription = despcription;
    }

    //задать нарпавление в другие локации
    public void putWay(Direction direction, Location location)
    {
        way.put(direction, location);
    }

    //находится ли предмет в инвентаре
    public boolean find(String name)
    {
        return inventory.find(name);
    }

    public Item findItem(String sss)
    {
        return inventory.findItem(sss);
    }

    //положить предмет в рюкзак локации
    public void putItem(Item item)
    {
        inventory.add(item);
    }

    //поиск правильного пути
    public Location executeDirection(Direction direction, Location location)
    {
        if(way.containsKey(direction))
        {
            location = way.get(direction);
            return location;
        }
        else
            System.out.println("Вы не можете туда идти.");

        return location;
    }

    public void remove(Item item)
    {
        inventory.remove(item);
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
}