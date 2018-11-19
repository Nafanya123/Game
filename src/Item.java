public class Item {

    private String name;
    private String properties;
    private Moveable moveable;

    Item(String name, Moveable moveable, String properties)
    {
        this.name = name;
        this.moveable = moveable;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public String getProperties() {
        return properties;
    }

    public Moveable getMoveable() {
        return moveable;
    }
}
