import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Location livingRoom = new Location("Гостинная", Direction.REPLIC_LIVING_ROOM_ALL_ITEMS.getCommand());
    static Location attic = new Location("Чердак", Direction.REPLIC_ATTIC.getCommand());
    static Location garden = new Location("Сад", Direction.REPLIC_GARDEN_ALL_ITEMS.getCommand());

    static Player player = new Player(livingRoom);
    //Гостиная
    static Item bucket = new Item("Ведро", Moveable.MOBILE, "Пустое ведро");
    static Item whiskey = new Item("Виски", Moveable.MOBILE, "Виски");
    static Item wizard = new Item("Волшебник", Moveable.STATIONARY, "Спящий волшебник");
    //Чердак
    static Item burner = new Item("Горелка", Moveable.STATIONARY, "Горелка");
    //Сад
    static Item chain = new Item("Цепь", Moveable.MOBILE, "Ржавая цепь");
    static Item frog = new Item("Лягушка", Moveable.STATIONARY, "Скользкая лягушка");
    static Item well = new Item("Колодец", Moveable.STATIONARY, "Колодец");

    private static void checkTake(String str)
    {
        if(str.equals(Direction.BUCKET.getCommand()) || str.equals(Direction.WHISKEY.getCommand()) ||
           str.equals(Direction.CHAIN.getCommand()) || str.equals(Direction.WIZARD.getCommand()) ||
           str.equals(Direction.WELL.getCommand()) || str.equals(Direction.FROG.getCommand()) ||
           str.equals(Direction.BURNENR.getCommand()))
        {
            player.take(str);
        }
    }
    private static void checkGo(String str)
    {
        if(str.equals(Direction.UP.getCommand()) || str.equals(Direction.DOWN.getCommand()) ||
           str.equals(Direction.WEST.getCommand()) || str.equals(Direction.EAST.getCommand()))
        {
            player.go(str);
        }
    }
    private static void checkLoc()
    {
        if(livingRoom.getInventory().find(bucket.getName()) && livingRoom.getInventory().find(whiskey.getName()))
        {
            livingRoom.setDespcription(Direction.REPLIC_LIVING_ROOM_ALL_ITEMS.getCommand());
        }
        else if(!livingRoom.getInventory().find(bucket.getName()) && livingRoom.getInventory().find(whiskey.getName()))
        {
            livingRoom.setDespcription(Direction.REPLIC_LIVING_ROOM_NOT_BUCKET.getCommand());
        }
        else if(livingRoom.getInventory().find(bucket.getName()) && !livingRoom.getInventory().find(whiskey.getName()))
        {
            livingRoom.setDespcription(Direction.REPLIC_LIVING_ROOM_NOT_WHISKEY.getCommand());
        }
        else if(!livingRoom.getInventory().find(bucket.getName()) && !livingRoom.getInventory().find(whiskey.getName()))
        {
            livingRoom.setDespcription(Direction.REPLIC_LIVING_ROOM_NOT_ALL.getCommand());
        }

        if(!garden.getInventory().find(chain.getName()))
        {
            garden.setDespcription(Direction.REPLIC_GARDEN_NOT_CHAIN.getCommand());
        }

    }

    private static void checkInventory(String str)
    {
        if(str.equals(Direction.INVENTORY.getCommand()))
        {
            player.invent();
        }
    }
    private static void checkLookAround(String str)
    {
        if(str.equals(Direction.LOOK_AROUND.getCommand()))
        {
            player.lookAround();
        }
    }

    private static void checkAll(String str)
    {
        if(!str.equals(Direction.UP.getCommand()) && !str.equals(Direction.DOWN.getCommand()) &&
           !str.equals(Direction.WEST.getCommand()) && !str.equals(Direction.EAST.getCommand()) &&
           !str.equals(Direction.LOOK_AROUND.getCommand()) && !str.equals(Direction.INVENTORY.getCommand()) &&
           !str.equals(Direction.BUCKET.getCommand()) && !str.equals(Direction.WHISKEY.getCommand()) &&
           !str.equals(Direction.CHAIN.getCommand()) && !str.equals(Direction.WIZARD.getCommand()) &&
           !str.equals(Direction.WELL.getCommand()) && !str.equals(Direction.DRINK_WHISKEY.getCommand()) &&
           !str.equals(Direction.USE_BUCKET_AND_CHAIN.getCommand()) && !str.equals(Direction.USE_BUCKET_ON_WIZARD.getCommand()) &&
           !str.equals(Direction.USE_BUCKET_ON_WELL.getCommand()) && !str.equals(Direction.BURNENR.getCommand()))
        {
            System.out.println("не верная команда");
        }
    }

    private static void checkUseItem(String str)
    {
        if(str.equals(Direction.USE_BUCKET_AND_CHAIN.getCommand()) || str.equals(Direction.USE_BUCKET_ON_WELL.getCommand()) ||
           str.equals(Direction.USE_BUCKET_ON_WIZARD.getCommand()) || str.equals(Direction.DRINK_WHISKEY.getCommand()))
        {
            player.use(str);
        }
    }
    public static void main(String[] args) {

        boolean start = true;

        livingRoom.dl.put(Direction.UP, attic);
        livingRoom.dl.put(Direction.WEST, garden);
        attic.dl.put(Direction.DOWN, livingRoom);
        garden.dl.put(Direction.EAST, livingRoom);


        //добавляем вещи на локации
        livingRoom.putItem(bucket);
        livingRoom.putItem(whiskey);
        livingRoom.putItem(wizard);
        attic.putItem(burner);
        garden.putItem(chain);
        garden.putItem(frog);
        garden.putItem(well);

        while (start)
        {
            checkLoc();
            System.out.println(" ");
            String q = sc.nextLine().toLowerCase();
            checkAll(q);
            checkGo(q);
            checkTake(q);
            checkLookAround(q);
            checkInventory(q);
            checkUseItem(q);
            if(player.getInventory().find("Кристалл"))
            {
                start = false;
            }
            else if(!player.isSobriety())
            {
                System.out.println("Игра закончена! :(");
                start = player.isSobriety();
            }
        }
    }
}
