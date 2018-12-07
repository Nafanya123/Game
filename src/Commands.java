public class Commands {

    Help help = new Help();
    public void check(String[] input, Player player, Combination[] combinations) {

        switch (input[0]) {
            case "осмотреться":
                player.lookAround();
                break;
            case "сумка":
                player.inventory();
                break;
            case "идти":
                if (input.length == 2) {
                    player.go(input[1]);
                } else {
                    badArgsNotify(input[0]);
                }
                break;
            case "взять":
                if (input.length == 2) {
                    player.takeItem(input[1]);
                } else {
                    badArgsNotify(input[0]);
                }
                break;
            case "использовать":
                if (input.length == 3) {
                    player.use(input[1], input[2], combinations);
                } else {
                    badArgsNotify(input[0]);
                }
                break;
            case "команда":
                if (input.length == 2) {
                    help.aboutCommand(input[1]);
                } else {
                    badArgsNotify(input[0]);
                }
                break;
            case "команды":
            case "помощь":
                help.commands();
                break;
            case "выйти":
                System.out.println("Вы вышли");
                break;
            default:
                System.out.println(" Команда не найдена\n" +
                        " Для информации введите: команды или помощь");

        }

    }

    private void badArgsNotify(String command) {
        System.out.println(" Не верная команда\n" +
                " Для помощи введите: команда '" + command + "'");
    }
}
