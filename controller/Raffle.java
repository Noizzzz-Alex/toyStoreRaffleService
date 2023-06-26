package controller;

import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Raffle extends RaffleBaseModel implements AddDrawingToys, RemoveRaffleToys, IsNumeric {
    public List<ToyBaseModel> getToyList() {
        return toyList;
    }

    List<ToyBaseModel> toyList = new LinkedList<>();
    private int id;
    private final LocalDate currentDate;
    {
        currentDate = LocalDate.now();
        id++;
    }



    String greetingText = "Здравствуйте, наконец-то этот день настал и" +
            " мы начинаем новый розыгрыш!";
    String errorTextChoice = """
            Ошибка ввода!
            Повторите ввод""";

    @Override
    public void startNewRaffle(List<ToyBaseModel> toys, List<ToyBaseModel> drawingsToysList) {
        Random random = new Random();
        System.out.println(greetingText);
        if (toys.isEmpty()) {
            System.out.println("Пополните список игрушек!");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Сколько игрушек хотите розыграть?: ");
            String temp = scanner.nextLine();
            if (isNumeric(temp)) {
                int amount = Integer.parseInt(temp);
                while (amount > 1) {
                    for (int i = 0; i < toys.size(); i++) {
                        int totalChance = random.nextInt(0, 100);
                        for (ToyBaseModel toy : toys) {
                            if (totalChance < toy.getChance()) {
                                System.out.println(toy.getName());
                                drawingsToysList.add(toy);
                                toys.remove(toy);
                                amount--;
                                break;
                            }
                        }
                    }
                }
            } else System.out.println(errorTextChoice);
        }
        System.out.println("Розыгрыш завершен!");

    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Формат вывода даты
        String formattedDate = currentDate.format(formatter);
        return String.format("Raffle#%d__%s", id, formattedDate);
    }

    @Override
    public void addedRaffleToys(List<ToyBaseModel> toys, ToyBaseModel toy) {
        toys.add(toy);
    }
    @Override
    public void removeRaffleToys(List<ToyBaseModel> toys, ToyBaseModel toy) {
        toys.remove(toy);
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
}
