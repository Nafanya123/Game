public class Help {

    private String inventory = "Команда: 'сумка'\n" +
                               "Данная команда показывает, что у вас лежит в сумке \n";

    private String lookAround = "Команда: 'осмотреться'\n" +
                                "Данная команда информирует вас, где вы находитесь \n";

    private String go = "Команда 'идти' \n" +
            "Данная команда позволяет перемещаться между комнатами. \n" +
            "Что бы задать направление введите команду: \n" +
            "- идти вверх\n" +
            "- идти вниз\n" +
            "- идти запад\n" +
            "- идти восток\n";
    private String take = "Команда 'взять'. \n" +
            "Данная команда предназначена для сбора доступных предметов в комнате. \n" +
            "Примеры: \n" +
            "> взять цепь \n" +
            "> взять ведро \n";

    private String use = "Команда 'использовать'. \n" +
            "Данная команда предназначена для создания нового предмета из двух иющихся. \n" +
            "Важно, что бы все предметы находились у вас в сумке, а так же, для создания новых вещей \n" +
            "вам потребуется некоторые предметы, находящиеся в зонах передвижения. \n" +
            "Примеры: \n" +
            "> использовать 'предмет' 'предмет' \n" +
            "> использовать ведро колодец \n";

    public void howToPlay() {
        System.out.println("По сюжету вы находитесь в доме волшебника.\n" +
                "Цель игры: разбудить волшебника и получить у него магический кристалл.\n" +
                "Некоторые предметы можно подибрать и делать из них новые \n");
    }

    public void commands() {
        String separator = "********************** \n";
        System.out.println("Список доступных команд: \n" +
                separator + inventory +
                separator + lookAround +
                separator + take +
                separator + go +
                separator + use +
                separator);
    }

    public void aboutCommand(String command) {
        switch (command) {
            case "осмотреться":
                System.out.println(lookAround);
                break;
            case "сумка":
                System.out.println(inventory);
                break;
            case "взять":
                System.out.println(take);
                break;
            case "использовать":
                System.out.println(use);
                break;
            case "идти":
                System.out.println(go);
                break;
            default:
                System.out.println(" Команда не найдена\n" +
                        " Для информации введите: команды или помощь");
        }
    }

}
