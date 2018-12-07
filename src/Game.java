import java.util.Scanner;

public class Game {

    private Scanner sc = new Scanner(System.in);

    Help help = new Help();
    private Location livingRoom = new Location("Гостинная", "Вы находитесь в гостиной в доме волшебника.\n" +
                                                "А вот и он сам громко храпит на кровати.\n" +
                                                "На западе от вас есть дверь, рядом лестница наверх.\n" +
                                                "Здесь находятся: ведро, бутылка виски. \n");
    private Location attic = new Location("Чердак", "Вы на чердаке старого дома.\n" +
                                          "В углу видна гигантская горелка.\n" +
                                          "Вниз ведет лестница. \n");
    private Location garden = new Location("Сад", "Вы в прекрасном саду.\n" +
                                            "Прямо по курсу находится колодец. \n" +
                                            "На востоке дверь в дом.\n" +
                                            "Здесь находятся: лягушка, цепь. \n");

    private Player player = new Player(livingRoom);

    //Гостиная
    private Item bucket = new Item("ведро", Moveable.MOBILE, "Пустое ведро \n");
    private Item bucketChain = new Item("ведро", Moveable.MOBILE, "Ведро с цепью \n");
    private Item bucketChainWater = new Item("ведро", Moveable.MOBILE, "Ведро наполненное водой \n");
    private Item whiskey = new Item("виски", Moveable.MOBILE, "Виски \n");
    private Item wizard = new Item("волшебник", Moveable.STATIONARY, "Спящий волшебник \n");

    private Item cry = new Item("Кристалл", Moveable.MOBILE, "Кристалл \n");
    //Чердак
    private Item burner = new Item("горелка", Moveable.STATIONARY, "Горелка \n");
    //Сад
    private Item chain = new Item("цепь", Moveable.MOBILE, "Ржавая цепь \n");
    private Item frog = new Item("лягушка", Moveable.STATIONARY, "Скользкая лягушка \n");
    private Item well = new Item("колодец", Moveable.STATIONARY, "Колодец \n");

    private Combination[] combination;
    private Commands commands = new Commands();

    private void initialization()
    {

        livingRoom.putDirections(Direction.UP, attic);
        livingRoom.putDirections(Direction.WEST, garden);
        attic.putDirections(Direction.DOWN, livingRoom);
        garden.putDirections(Direction.EAST, livingRoom);

        livingRoom.putItem(bucket);
        livingRoom.putItem(whiskey);
        livingRoom.putItem(wizard);
        attic.putItem(burner);
        garden.putItem(chain);
        garden.putItem(frog);
        garden.putItem(well);

        combination = new Combination[]
        {
                new Combination(bucketChain, well, bucketChainWater, "Вы наполнили ведро водой! \n"),
                new Combination(bucket, chain, burner, bucketChain, "Вы приварили цепь к ведру! \n"),
                new Combination(bucketChainWater, wizard, cry, "Вы облили волшеника! \n"),

                new Combination(bucket, frog, null, "Вы пытаетесь поймать лягушку ведром, но она ускользаяет от вас \n"),
                new Combination(bucket, well, null, "Колодец слишком длинный, до воды не достать \n"),
                new Combination(bucket, wizard, null, "Ведро пустое \n"),
                new Combination(bucket, chain, null, "Нечем приваривать цепь к ведру \n"),
                new Combination(bucket, whiskey, null, "Виски тут никак не поможет \n"),

                new Combination(chain, frog, null, "Нельзя посадить лягушку на цепь \n"),
                new Combination(chain, well, null, "С помощью цепи нельзя набрать воды \n"),
                new Combination(chain, wizard, null, "Нельзя волшебника посадить на цепь \n"),
                new Combination(chain, whiskey, null, "Виски тут никак не поможет \n"),
                new Combination(chain, chain, null, "Нечего приваривать к цепи \n"),

        };
    }

    private void checkDescription()
    {
        if(!livingRoom.find(bucket.getName()) && livingRoom.find(whiskey.getName()))
        {
            livingRoom.setDescription("Вы находитесь в гостиной в доме волшебника. \n" +
                    "А вот и он сам громко храпит на кровати.\n" +
                    "На западе от вас есть дверь, рядом лестница наверх. \n" +
                    "Здесь находятся: бутылка виски. \n");
        }
        else if(livingRoom.find(bucket.getName()) && !livingRoom.find(whiskey.getName()))
        {
            livingRoom.setDescription("Вы находитесь в гостиной в доме волшебника. \n" +
                    "А вот и он сам громко храпит на кровати.\n" +
                    "На западе от вас есть дверь, рядом лестница наверх. \n" +
                    "Здесь находятся: ведро \n");
        }
        else if(!livingRoom.find(bucket.getName()) && !livingRoom.find(whiskey.getName()))
        {
            livingRoom.setDescription("Вы находитесь в гостиной в доме волшебника. \n" +
                    "А вот и он сам громко храпит на кровати.\n" +
                    "На западе от вас есть дверь, рядом лестница наверх. \n");
        }

        if(!garden.find(chain.getName()))
        {
            garden.setDescription("Вы в прекрасном саду.\n" +
                    "Прямо по курсу находится колодец. \n" +
                    "На востоке дверь в дом. Здесь находятся: лягушка \n");
        }
    }


    public void start()
    {
        boolean start = true;
        initialization();
        help.howToPlay();
        while(start)
        {

            checkDescription();
            System.out.println("======================");
            String[] string = sc.nextLine().toLowerCase().split(" ");
            if(string[0].equals("выйти"))
            {
                start = false;
            }
            commands.check(string, player, combination);
            if(player.find(cry))
            {
                System.out.println("Поздравляем, вы разбудили волшебника и получили кристалл!");
                start = false;
            }

        }
    }
}
