package view;

import controller.Drawing;
import model.NewDrawing;
import model.StartMainMenu;

import java.util.Scanner;

public class MainMenu implements StartMainMenu {
    String greetingText = "День добрый";
    String choiceText = """
            Выберите действие:
            1. Новый розыгрыш
            2. Показать списки розыгрышей
            3. Выход""";
    String errorTextChoice = """
            Неизвестная команда!
            Повторите ввод""";

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greetingText);
        System.out.println(choiceText);
        String choice = "";
        while (!(choice.equals("3"))) {
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("команда №1");
                    NewDrawing newDrawing = new Drawing();
                    newDrawing.startNewDrawing();
                }
                case "2" -> {
                    System.out.println("команда №2");
                }
                default -> {
                    System.out.println(errorTextChoice);
                    choice = scanner.nextLine();
                }
            }
        }
    }
}
