package controller;

import model.ConsoleBaseModel;
import model.NewDrawing;

import java.util.Scanner;

public class Console extends ConsoleBaseModel {
    String greetingText = "День добрый";
    String choiceText = """
            Выберите действие:
            1. Новый розыгрыш
            2. Показать списки розыгрышей
            3. Выход""";
    String errorTextChoice = """
            Неизвестная команда!
            Повторите ввод""";
    NewDrawing newDrawing = new Drawing();

    @Override
    public void start() {
        mainMenu();
    }

    @Override
    protected void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greetingText);
        System.out.println(choiceText);
        String choice = "";
        while (!(choice.equals("3"))) {
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    subMenuDrawing(newDrawing);
                }
                case "2" -> {
                    System.out.println("команда №2");
                }
                case "3" -> {
                    System.out.println("команда №3");
                    mainMenu();
                }

                default -> {
                    System.out.printf("%s\n%s\n", errorTextChoice, choiceText);
                    choice = scanner.nextLine();
                }
            }
        }
    }

    @Override
    protected void subMenuDrawing(NewDrawing newDrawing) {
        System.out.println("this is submenu");
        System.out.println("команда №1");
        newDrawing.startNewDrawing();
    }

    @Override
    protected void subMenuAddedToysForDrawing(NewDrawing newDrawing) {
        System.out.println("А теперь необходимо добавить игрушек для розыгрыша");

    }
}
