import java.util.Map;

public class Player {

    private Location location;
    private Inventory inventory = new Inventory();



    private boolean hangover = false;
    private Item item;
    private Walking walk;

    Player(Location location)
    {
        this.location = location;
        walk = new Walking();
    }

    public void lookAround()
    {
        System.out.print(location.getDespcription());
    }

    public void inventory()
    {
            inventory.show();
    }

    public void use(String item_1, String item_2, Combination[] combinations)
    {
        boolean start = true;
        Item itemFirst = inventory.findItem(item_1);
        Item locationItem = location.findItem(item_2);
        Item itemSecond = inventory.findItem(item_2);

        if(!inventory.find(item_2))
        {
            if(locationItem != null)
            {
                itemSecond = locationItem;
            }
            else
            {
                System.out.println(" ! Предмет(ы) или объект(ы) отсутствует или вы допустили ошибку в его названии\n" +
                        " ! Для помощи введите: команда использовать");
                start = false;
            }
        }

        if(itemFirst == null)
        {
            System.out.println(" ! У вас нет указанного предмета в инвентаре или неккоректно введено его название\n" +
                    " ! Для помощи введите: команда использовать");
            start = false;
        }
        else if(itemSecond.equals(null))
        {
            if(locationItem != null)
            {
                itemSecond = locationItem;
            }
            else
            {
                System.out.println(" ! Предмет(ы) или объект(ы) отсутствует или вы допустили ошибку в его названии\n" +
                        " ! Для помощи введите: команда использовать");
                start = false;
            }
        }

        if(start)
        {
            for(Combination combination : combinations)
            {
                Item combFirst = combination.getItem_1();
                Item combSecond = combination.getItem_2();
                Item locItem = combination.getItem_3();

                if((itemFirst.equals(combFirst) && itemSecond.equals(combSecond) && locItem == null) ||
                        (itemFirst.equals(combSecond) && itemSecond.equals(combFirst) && locItem == null)) {
                    if (combination.getResult() != null) {
                        if (itemFirst.getMoveable().equals(Moveable.MOBILE)) {
                            inventory.remove(itemFirst);
                        }

                        if (itemSecond.getMoveable().equals(Moveable.MOBILE)) {
                            inventory.remove(itemSecond);
                        }
                        inventory.add(combination.getResult());
                    }
                    System.out.println(combination.printMessage());
                    return;
                }
                else if((itemFirst.equals(combFirst) && itemSecond.equals(combSecond) && location.find(locItem.getName())) ||
                (itemFirst.equals(combSecond) && itemSecond.equals(combFirst) && location.find(locItem.getName())))
                {
                    if (combination.getResult() != null) {
                        if (itemFirst.getMoveable().equals(Moveable.MOBILE)) {
                            inventory.remove(itemFirst);
                        }

                        if (itemSecond.getMoveable().equals(Moveable.MOBILE)) {
                            inventory.remove(itemSecond);
                        }
                        inventory.add(combination.getResult());
                    }
                    System.out.println(combination.printMessage());
                    return;
                }
            }
        }
    }
    public void go(String route)
    {
        Direction direction;
        direction = walk.go(route);

        if(direction != null)
        {
            location = location.nextLocation(direction, location);
        }
        lookAround();
    }

    public void takeItem(String nameItem)
    {
        if(location.find(nameItem))
        {
            item = location.findItem(nameItem);
            if(item.getMoveable().equals(Moveable.MOBILE))
            {
                System.out.println("Вы подобрали: " + item.getName());
                inventory.add(item);
                location.remove(item);
            }
        }
        else
        {
            System.out.println(nameItem + " нету");
        }
    }

    public boolean find(Item item)
    {
        return inventory.find(item.getName());
    }

    public boolean isHangover() {
        return hangover;
    }

}
