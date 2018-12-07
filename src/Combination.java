public class Combination {

    private Item item_1;
    private Item item_2;
    private Item item_3;
    private Item result;
    private String message;

    public Combination(Item item_1, Item item_2, Item result, String message)
    {
        this.item_1 = item_1;
        this.item_2 = item_2;
        this.item_3 = null;
        this.result = result;
        this.message = message;
    }

    public Combination(Item item_1, Item item_2, Item itemNoMoveable, Item result, String message)
    {
        this.item_1 = item_1;
        this.item_2 = item_2;
        this.item_3 = itemNoMoveable;
        this.result = result;
        this.message = message;
    }
    public Item getResult() {
        return result;
    }

    public Item getItem_1() {
        return item_1;
    }

    public Item getItem_2() {
        return item_2;
    }

    public Item getItem_3() {
        return item_3;
    }

    public String printMessage()
    {
        return message;
    }
}
