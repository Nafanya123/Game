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

    public void checkLocation()
    {
        if(name.equals("Гостинная"))
        {
            if(inventory.find(updateName(Direction.BUCKET.getCommand())) &&
               inventory.find(updateName(Direction.WHISKEY.getCommand())))
            {
                despcription = Replic.REPLIC_LIVING_ROOM_ALL_ITEMS.getReplic();
            }
            else if(!inventory.find(updateName(Direction.BUCKET.getCommand())) &&
                    inventory.find(updateName(Direction.WHISKEY.getCommand())))
            {
                despcription = Replic.REPLIC_LIVING_ROOM_NOT_BUCKET.getReplic();
            }
            else if(inventory.find(updateName(Direction.BUCKET.getCommand())) &&
                    !inventory.find(updateName(Direction.WHISKEY.getCommand())))
            {
                despcription =  Replic.REPLIC_LIVING_ROOM_NOT_WHISKEY.getReplic();
            }
            else if(!inventory.find(updateName(Direction.BUCKET.getCommand())) &&
                    !inventory.find(updateName(Direction.WHISKEY.getCommand())))
            {
                despcription = Replic.REPLIC_LIVING_ROOM_NOT_ALL.getReplic();
            }
        }

        if(name.equals("Сад"))
        {
            if(!inventory.find(updateName(Direction.CHAIN.getCommand())))
            {
                despcription = Replic.REPLIC_GARDEN_NOT_CHAIN.getReplic();
            }
        }
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

    public Inventory getInventory() {
        return inventory;
    }

    //удаляет первое слово
    private String updateName(String name)
    {
        name = name.replace("взять ", "");
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        return name;
    }
}