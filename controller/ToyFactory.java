package controller;

import model.CreatingToy;
import model.IsNumeric;
import model.ToyBaseModel;
import model.ToyFactoryBaseModel;

import java.util.List;
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
        System.out.println("Какую игрушку хотите создать?");
        System.out.println(choiceText);
        while (!(choice.equals("0"))) {
            choice = scanner.nextLine();
            switch (choice) {
                case "1", "2", "3" -> {
                    System.out.print("Введите количество игрушек: ");
                    String temp = scanner.nextLine();
                    if (isNumeric(temp)) {
                        int amount = Integer.parseInt(temp);
                        System.out.print("Введите шанс выпадения(%): ");
                        temp = scanner.nextLine();
                        if (isNumeric(temp)) {
                            int chance = Integer.parseInt(temp);
                            createNewToy(Integer.parseInt(choice), amount, chance, toys);
                            System.out.println(choiceText);
                        } else System.out.println(errorTextChoice);
                    }
                }
            }
        }
    }


    @Override
    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
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
        assert toy != null;
        System.out.printf("%d игрушек %s с шансом выпадения (%d) созданы и добавлены\n",
                amount, toy.getName(), toy.getChance());
    }
}

