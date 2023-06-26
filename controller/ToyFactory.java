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
        String choice = "";
        int amount = 0;
        int chance = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какую игрушку хотите создать?");
        while (!(choice.equals("0"))) {
            System.out.println(choiceText);
            choice = scanner.nextLine();
            if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
                System.out.println("Введите количество игрушек: ");
                scanner.nextLine();
                if (scanner.hasNextInt()) {
                    amount = scanner.nextInt();
                    System.out.println("Введите шанс выпадения(%): ");
                    scanner.nextLine();
                    if (scanner.hasNextInt()) {
                        chance = scanner.nextInt();
                        createNewToy(Integer.parseInt(choice), amount, chance, toys);
                    }
                } else System.out.println(errorTextChoice);
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

    @Override
    public void createNewToy(int count, int amount, int chance, List<ToyBaseModel> toys) {
        ToyBaseModel toy = null;
        if (count == 1) {
            toy = new ToyRobot("Робот", chance);
        }
        if (count == 2) {
            toy = new ToyAuto("Машинка", chance);
        }
        if (count == 3) {
            toy = new ToyTeddyBear("Медвежонок", chance);
        }
        for (int i = 0; i < amount; i++) {
            toys.add(toy);
        }
        System.out.printf("%d игрушек %s с шансом выпадения (%d) созданы и добавлены\n",
                amount, toy.getName(), toy.getChance());
    }
}

//        if (isNumeric(scanner.nextLine())&&!scanner.nextLine().isEmpty()) {
//            int amount = Integer.parseInt(scanner.nextLine());
//
//            if (isNumeric(scanner.nextLine())) {
//                int chance = Integer.parseInt(scanner.nextLine());
//        ToyBaseModel tempToy = new ToyRobot("Робот", chance);
//        addedToys(tempToy, amount, toys);
//    }


//    getName());
//        } else {
//            System.out.printf("%s\n%s\n", errorTextChoice, choiceText);
//            scanner.nextLine();
//}
