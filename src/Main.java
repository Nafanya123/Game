import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Location livingRoom = new Location("Гостинная", Replic.REPLIC_LIVING_ROOM_ALL_ITEMS.getReplic());
        Location attic = new Location("Чердак", Replic.REPLIC_ATTIC.getReplic());
        Location garden = new Location("Сад", Replic.REPLIC_GARDEN_ALL_ITEMS.getReplic());

        Player player = new Player(livingRoom);
        //Гостиная
        Item bucket = new Item("Ведро", Moveable.MOBILE, "Пустое ведро");
        Item whiskey = new Item("Виски", Moveable.MOBILE, "Виски");
        Item wizard = new Item("Волшебник", Moveable.STATIONARY, "Спящий волшебник");
        //Чердак
        Item burner = new Item("Горелка", Moveable.STATIONARY, "Горелка");
        //Сад
        Item chain = new Item("Цепь", Moveable.MOBILE, "Ржавая цепь");
        Item frog = new Item("Лягушка", Moveable.STATIONARY, "Скользкая лягушка");
        Item well = new Item("Колодец", Moveable.STATIONARY, "Колодец");
        boolean start = true;

        livingRoom.putWay(Direction.UP, attic);
        livingRoom.putWay(Direction.WEST, garden);
        attic.putWay(Direction.DOWN, livingRoom);
        garden.putWay(Direction.EAST, livingRoom);


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
            player.checkLocation();
            System.out.println(" ");
            String console = sc.nextLine().toLowerCase();
            Direction.CHECK.checkAllCommands(console);
            player.go(console);
            player.take(console);
            player.lookAround(console);
            player.inventory(console);
            player.use(console);
            if(player.find("Кристалл"))
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
