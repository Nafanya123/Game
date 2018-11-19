public class Combo {

    private Item result;

    public void craft(Item object, Item subject, Inventory inventory, Inventory location)
    {
        if(object.getProperties().equals("Ведро с цепью") && subject.getProperties().equals("Колодец"))
        {
            result = new Item("Ведро", Moveable.MOBILE, "Ведро с водой");
            inventory.add(result);
            System.out.println("Вы получили: " + result.getProperties());
            inventory.remove(object);
        }
        else if(object.getProperties().equals("Ведро с водой") && subject.getProperties().equals("Спящий волшебник"))
        {
            Item result = new Item("Кристалл", Moveable.MOBILE, "Драгоценный камень");
            System.out.println("Вы получили: " + result.getProperties());
            inventory.add(new Item("Ведро", Moveable.MOBILE, "Ведро с цепью"));
            inventory.add(result);
            inventory.remove(object);
            location.add(new Item("Волшебник", Moveable.STATIONARY, "Бодрый волшебник"));
            System.out.println("Вы выйграли, поздравляем!!!");
        }
        else if(object.getProperties().equals("Пустое ведро") && subject.getProperties().equals("Спящий волшебник"))
        {
            System.out.println("В ведре пусто");
        }
        else if(object.getProperties().equals("Ведро с цепью") && subject.getProperties().equals("Спящий волшебник"))
        {
            System.out.println("В ведре пусто");
        }
        else
        {
            System.out.println("Нет нужных вещей");
        }
    }

    public void craft(Item object, Item objectTwo, Item subject, Inventory inventory)
    {
        if(object.getProperties().equals("Пустое ведро") && objectTwo.getProperties().equals("Ржавая цепь") && subject.getProperties().equals("Горелка"))
        {
            result = new Item("Ведро", Moveable.MOBILE, "Ведро с цепью");
            inventory.add(result);
            System.out.println("Вы получили: " + result.getProperties());
            inventory.remove(object);
            inventory.remove(objectTwo);
        }
        else if (object.getProperties().equals("Ржавая цепь") && objectTwo.getProperties().equals("Пустое ведро") && subject.getProperties().equals("Горелка"))
        {
            result = new Item("Ведро", Moveable.MOBILE, "Ведро с цепью");
            inventory.add(result);
            System.out.println("Вы получили: " + result.getProperties());
            inventory.remove(object);
            inventory.remove(objectTwo);
        }
        else
        {
            System.out.println("Нет нужных вещей");
        }
    }
}
