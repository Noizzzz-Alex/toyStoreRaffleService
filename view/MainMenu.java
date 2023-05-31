package view;

import java.util.Scanner;

public class MainMenu {
    public void start() {
        System.out.println("""
                Выберите действие:
                1. Новый розыгрыш
                2. Показать списки розыгрышей
                3. Выход""");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        while (choice != "3") {
            switch (choice) {
                case "1":

                    break;
                case "2":

                    break;
                default:
                    System.out.println("Неизвестная команда");
            }
        }
    }
}
