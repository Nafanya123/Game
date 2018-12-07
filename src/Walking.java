public class Walking implements WalkinBehavior{

    Direction direction;


    public Direction go(String route)
    {
        switch (route)
        {
            case "вверх":
                direction = Direction.UP;
                break;
            case "вниз":
                direction = Direction.DOWN;
                break;
            case "запад":
                direction = Direction.WEST;
                break;
            case "восток":
                direction = Direction.EAST;
                break;
            default:
                direction = null;
        }
        return direction;
    }
}
