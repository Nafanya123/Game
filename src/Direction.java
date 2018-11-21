import java.util.ArrayList;

public enum Direction {

    UP("идти верх"),
    DOWN("идти вниз"),
    WEST("идти запад"),
    EAST("идти восток"),
    NORTH("идти на север"),
    SOUTH("идти на юг"),

    LOOK_AROUND("осмотреться"),
    INVENTORY("инвентарь"),

    BUCKET("взять ведро"),
    WHISKEY("взять виски"),
    CHAIN("взять цепь"),
    WIZARD("взять волшебника"),
    BURNENR("взять горелку"),
    WELL("взять колодец"),
    FROG("взять лягушку"),

    DRINK_WHISKEY("выпить виски"),
    USE_BUCKET_AND_CHAIN("использовать цепь на ведро"),
    USE_BUCKET_ON_WELL("использовать ведро на колодец"),
    USE_BUCKET_ON_WIZARD("использовать ведро на волшебника"),

    CHECK;

    private String command;
    private ArrayList<String> necessaryCommands;
    Direction(){}

    Direction(String command)
    {
        this.command = command;
    }

    public String getCommand()
    {
        return command;
    }

    public void checkAllCommands(String str)
    {
        necessaryCommands = new ArrayList<>();

        for (Direction array: Direction.values())
        {
            necessaryCommands.add(array.getCommand());
        }

        if(!necessaryCommands.contains(str))
        {
            System.out.println("не верная команда");
        }
    }
}