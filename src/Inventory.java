import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {

    private ArrayList<Item> inventory = new ArrayList<Item>();

    public void add(Item item)
    {
        inventory.add(item);
    }

    public void remove(Item item)
    {
        inventory.remove(item);
    }

    public void show()
    {
        if(inventory.isEmpty())
        {
            System.out.println("Пусто");
        }
        else
        {
            for(Item items: inventory)
            {
                System.out.println(items.getProperties());
            }
        }
    }

    public boolean find(String name)
    {
        for (Item item : inventory)
        {
            if(item.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public Item findItem(String name)
    {
        Item item = null;
        for(Item items : inventory)
        {
            item = items;
            if(name.equals(item.getName()))
            {
                return item;
            }
        }
        return item;
    }
}