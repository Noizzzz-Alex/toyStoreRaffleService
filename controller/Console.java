package controller;

import model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        while (!(choice.equals(" "))) {
            System.out.println(choiceText);
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    subMenuRaffle(newRaffle, raffleToysList);
                    raffleList.add(newRaffle);
                    saveToFile(newRaffle);
                }
                case "2" -> {
                    System.out.println("Выводим список розыгрышей: ");
                    if (raffleList.isEmpty()) {
                        System.out.println("Список розыгрышей пуст");
                    } else {
                        raffleList.forEach(System.out::println);
                    }
                }
                case "3" -> {
                    System.out.println("Переходим к созданию: ");
                    ToyFactoryBaseModel toyFactory = new ToyFactory();
                    toyFactory.createNewToy(newRaffle.getToyList());


                }
                case "0" -> {
                    System.out.println("До следующего раза!");
                    return;
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
        fileName = fileName.replace("#", "-").replace(":", "_").replace("№", "");
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String formattedDateTime = currentDateTime.format(formatter);
        String finalFileName = fileName + "_" + formattedDateTime;
        String directoryPath = "resourceFiles";
        String filePath = directoryPath + File.separator + finalFileName + ".txt";

        File directory = new File(directoryPath);
        if (!directory.exists()) directory.mkdirs();

        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Файл создан: " + filePath);
            try (FileWriter fileWriter = new FileWriter(file)) {
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                String drawingName = String.format("|%-10s|розыграно: %d игрушек|%s|\n",
                        newRaffle, raffleToysList.size(), formattedDateTime);
                bufferedWriter.write(drawingName);
                for (ToyBaseModel toy : raffleToysList) {
                    bufferedWriter.write(toy.toString());
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                System.out.println("Файл успешно записан.");
            }
        }
    }
}

