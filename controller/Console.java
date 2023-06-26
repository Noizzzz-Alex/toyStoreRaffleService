package controller;

import model.ConsoleBaseModel;
import model.DrawingBaseModel;
import model.ToyBaseModel;
import model.ToyFactoryBaseModel;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Console extends ConsoleBaseModel {
    List<ToyBaseModel> toyList = new LinkedList<>();
    List<DrawingBaseModel> drawingsList = new LinkedList<>();
    String greetingText = "День добрый";
    String choiceText = """
            Выберите действие:
            1. Новый розыгрыш
            2. Показать списки розыгрышей
            3. Добавить игрушки для розыгрыша
            0. Выход""";
    String errorTextChoice = """
            Неизвестная команда!
            Повторите ввод""";
    DrawingBaseModel newDrawing = new Drawing();

    @Override
    public void start() {
        mainMenu();
    }

    @Override
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greetingText);

        String choice = "";
        while (!(choice.equals("0"))) {
            System.out.println(choiceText);
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    subMenuDrawing(newDrawing);
                    drawingsList.add(newDrawing);
                }
                case "2" -> {
                    System.out.println("команда №2");
                    drawingsList.forEach(System.out::println);
                }
                case "3" -> {
                    System.out.println("команда №3");
                    ToyFactoryBaseModel toyFactory = new ToyFactory();
                    toyFactory.createNewToy(toyList);


                }
                case "4" -> {
                    System.out.println("команда №4");
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
    protected void subMenuDrawing(DrawingBaseModel newDrawing) {
        newDrawing.startNewDrawing(toyList);
        System.out.println("Завершение subMenuDrawing");


    }

    @Override
    protected void subMenuAddedToysForDrawing(DrawingBaseModel newDrawing) {
        System.out.println("А теперь необходимо добавить игрушек для розыгрыша");

    }
}
