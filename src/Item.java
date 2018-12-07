public class Item {



    private String name;

    public String getProperties() {
        return properties;
    }

    private String properties;

    public Moveable getMoveable() {
        return moveable;
    }

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

}
