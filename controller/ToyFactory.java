package controller;
import model.CreatingToy;
import model.IsNumeric;
import model.ToyBaseModel;
import model.ToyFactoryBaseModel;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ToyFactory extends ToyFactoryBaseModel implements IsNumeric, CreatingToy {
    String choiceText = """
            Выберите действие:
            1. Игрушка робот
            2. Игрушка машинка
            3. Игрушка медвежонок
            0. Назад в Главное меню""";
    String errorTextChoice = """
            Ошибка ввода!
            Повторите ввод""";
    Scanner scanner = new Scanner(System.in);


    @Override
    public void createNewToy(List<ToyBaseModel> toys) {
        System.out.println("Какую игрушку хотите создать?");
        String choice = "";
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while (!(choice.equals("0"))) {
            System.out.println(choiceText);
            choice = scanner.nextLine();
            ToyBaseModel tempToy;
            if (choice.equals("1")) {


            }
            if (choice.equals("2")) {
                ToyBaseModel toy = new ToyTeddyBear("Машинка", random.nextInt(0, 100));
                toys.add(toy);
            }
            if (choice.equals("3")) {
                ToyBaseModel toy = new ToyAuto("Медвежонок", random.nextInt(0, 100));
                toys.add(toy);
            }

        }
    }


    @Override
    public boolean isNumeric(String str) {
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;

    }

    private void addedToys(ToyBaseModel toy, int amount, List<ToyBaseModel> toys) {
        for (int i = 0; i < amount; i++) {
            toys.add(toy);
        }

    }

    @Override
    public void createNewToy(String count) {
        ToyBaseModel toy = null;
        if (count.equals("1")) {
            toy = new ToyRobot();
        }
        System.out.println("Введите количество игрушек: ");
        if (isNumeric(scanner.nextLine())&&!scanner.nextLine().isEmpty()) {
            int amount = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите шанс выпадения(%): ");
            if (isNumeric(scanner.nextLine())) {
                int chance = Integer.parseInt(scanner.nextLine());
                ToyBaseModel tempToy = new ToyRobot("Робот", chance);
                addedToys(tempToy, amount, toys);
            }
            System.out.printf("%d игрушек %s созданы и добавлены\n",amount, toys.get(0).getName());
        } else {
            System.out.printf("%s\n%s\n", errorTextChoice, choiceText);
            scanner.nextLine();
        }
    }
}