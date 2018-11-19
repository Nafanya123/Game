public class Player {

    private Location location;
    private boolean sobriety = true;
    private Inventory inventory = new Inventory();
    private Combo combo = new Combo();

    Player(Location location)
    {
        this.location = location;
        System.out.println(location.getDespcription());
    }

    public void use(String str)
    {
        if(inventory.find(updateNameObject(str)) && inventory.find(updateNameObjectTwo(str)))
        {
            combo.craft(inventory.findItem(updateNameObject(str)), inventory.findItem(updateNameObjectTwo(str)),
                    location.getInventory().findItem("Горелка"), inventory);
        }
        else if(location.getInventory().find("Колодец") && inventory.find(updateNameObject(str)))
        {
            combo.craft(inventory.findItem(updateNameObject(str)), location.getInventory().findItem("Колодец"), inventory, location.getInventory());
        }
        else if(location.getInventory().find("Волшебник") && inventory.find(updateNameObject(str)))
        {
            combo.craft(inventory.findItem(updateNameObject(str)), location.getInventory().findItem("Волшебник"), inventory, location.getInventory());
        }
        else if(str.equals(Direction.DRINK_WHISKEY.getCommand()))
        {
            str = str.replace("выпить ", "");
            str = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
            if(inventory.find(str))
            {
                System.out.println("Вы напились");
                sobriety = false;
            }
        }
        else
        {
            System.out.println("что то не то");
        }
    }

    //открыть инвентарь игрока
    public void invent()
    {
        inventory.show();
    }

    public void take(String name)
    {
        if(name.equals(Direction.BUCKET.getCommand()))
        {
            if(location.getInventory().find(updateName(name)))
            {
                updateItems(updateName(name));

            }
            else
            {
                System.out.println(updateName(name) + " тут не найдено)");
            }
        }
        else if(name.equals(Direction.CHAIN.getCommand()))
        {
            if(location.getInventory().find(updateName(name)))
            {
                updateItems(updateName(name));
            }
            else
            {
                System.out.println(updateName(name) + " тут не найден(а)");
            }
        }
        else if(name.equals(Direction.WHISKEY.getCommand()))
        {
            if(location.getInventory().find(updateName(name)))
            {
                updateItems(updateName(name));
            }
            else
            {
                System.out.println(updateName(name) + " тут не найден(о)");
            }
        }
        else if(name.equals(Direction.WIZARD.getCommand()))
        {
            if(location.getInventory().find(updateLastChar(updateName(name))))
            {
                updateItems(updateLastChar(updateName(name)));
            }

            else
            {
                System.out.println(updateName(name) + " тут не найден(о)");
            }
        }
        else if(name.equals(Direction.WELL.getCommand()))
        {
            if(location.getInventory().find(updateName(name)))
            {
                updateItems(updateName(name));
            }
            else
            {
                System.out.println(updateName(name) + " тут не найден(о)");
            }
        }
        else if(name.equals(Direction.BURNENR.getCommand()))
        {
            name = updateName(name);
            name = name.substring(0, 6) + 'а';
            if(location.getInventory().find(updateName(name)))
            {
                updateItems(name);
            }
            else
            {
                System.out.println(updateName(name) + " тут не найден(о)");
            }
        }
        else
        {
            System.out.println("такой вещи не существует");
        }
    }
    public void lookAround()
    {
        System.out.print(location.getDespcription());
    }

    public void go(String route)
    {
        direction(route);
        lookAround();
    }

    //задать направление
    private void direction(String route)
    {
        if(route.equals(Direction.UP.getCommand()))
        {
            if(location.dl.containsKey(Direction.UP))
            {
                location = location.dl.get(Direction.UP);
            }
            else
                System.out.println("Вы не можете туда идти.");
        }
        else if(route.equals(Direction.DOWN.getCommand()))
        {
            if(location.dl.containsKey(Direction.DOWN))
            {
                location = location.dl.get(Direction.DOWN);
            }
            else
                System.out.println("Вы не можете туда идти.");
        }
        else if(route.equals(Direction.WEST.getCommand()))
        {
            if(location.dl.containsKey(Direction.WEST))
            {
                location = location.dl.get(Direction.WEST);
            }
            else
                System.out.println("Вы не можете туда идти.");
        }
        else if(route.equals(Direction.EAST.getCommand()))
        {
            if(location.dl.containsKey(Direction.EAST))
            {
                location = location.dl.get(Direction.EAST);
            }
            else
                System.out.println("Вы не можете туда идти.");
        }
    }

    //провеить перемещается ли вещь
    private void updateItems(String name)
    {
        if(location.getInventory().findItem(name).getMoveable().equals(Moveable.MOBILE))
        {
            inventory.add(new Item(name, Moveable.MOBILE, location.getInventory().findItem(name).getProperties()));
            location.getInventory().remove(location.getInventory().findItem(name));
            System.out.println("Подобрано: " + inventory.findItem(name).getProperties());
        }
        else
        {
            System.out.println(name + " не сможет поместиться к вам в сумку");
        }
    }

    //удаляет первое слово
    private String updateName(String name)
    {
        name = name.replace("взять ", "");
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        return name;
    }

    //удаляет последнюю буку а, для волшебника
    private String updateLastChar(String command)
    {
        if (command != null && command.length() > 0 && command.charAt(command.length() - 1) == 'а') {
            command = command.substring(0, command.length() - 1);
        }
        return command;
    }

    //удаляет первое слово и вырезает первую вещь
    private String updateNameObject(String name)
    {
        name = name.replace("использовать ", "");
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        name = name.split(" ")[0];
        return name;
    }

    //удаляет до 3 пробела
    private String updateNameObjectTwo(String name)
    {
        name = name.split(" ")[3];
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        return name;
    }

    public boolean isSobriety() {
        return sobriety;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
