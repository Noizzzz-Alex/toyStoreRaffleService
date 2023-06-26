package controller;

import model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Console extends ConsoleBaseModel implements SaveToFile {
    List<ToyBaseModel> raffleToysList = new LinkedList<>();

    List<RaffleBaseModel> raffleList = new LinkedList<>();
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
    RaffleBaseModel newRaffle = new Raffle();

    @Override
    public void start() throws IOException {
        mainMenu();
    }

    @Override
    public void mainMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greetingText);

        String choice = "";
        while (!(choice.equals("0"))) {
            System.out.println(choiceText);
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    subMenuRaffle(newRaffle, raffleToysList);
                    raffleList.add(newRaffle);
                    saveToFile(newRaffle);
                }
                case "2" -> {
                    System.out.println("команда №2");
                    raffleList.forEach(System.out::println);
                }
                case "3" -> {
                    System.out.println("команда №3");
                    ToyFactoryBaseModel toyFactory = new ToyFactory();
                    toyFactory.createNewToy(newRaffle.getToyList());


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
    protected void subMenuRaffle(RaffleBaseModel newDrawing, List<ToyBaseModel> drawingToysList) {
        newDrawing.startNewRaffle(newDrawing.getToyList(), drawingToysList);
        System.out.println("Завершение subMenuDrawing");


    }

    @Override
    protected void subMenuAddedToysForDrawing(RaffleBaseModel newDrawing) {
        System.out.println("А теперь необходимо добавить игрушек для розыгрыша");

    }

    @Override
    public void saveToFile(RaffleBaseModel newRaffle) throws IOException {
        String fileName = newRaffle.toString();
        String path = "resourceFiles";
        FileWriter fileWriter = new FileWriter(path + "/" + fileName + ".txt");
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile(); // Создание файла, если он не существует
                System.out.println("Файл создан: " + fileName);

                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                String drawingName = String.format("|_%-41s_|\n", newRaffle);
                bufferedWriter.write(drawingName);
                for (ToyBaseModel toy : raffleToysList) {
                    bufferedWriter.write(toy.toString());
                    bufferedWriter.newLine();
                    String content = String.format("|-%-15s-|-chance: %d\n", toy, toy.getChance());
                    bufferedWriter.write(content);
                }
                bufferedWriter.close();
                fileWriter.close();
                System.out.println("Файл успешно записан.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        }
    }
