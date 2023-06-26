package controller;

import model.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Drawing extends DrawingBaseModel implements AddDrawingToys, RemoveDrawingToys {
    private int id;
    private final Date date;
    {
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        date = new Date(System.currentTimeMillis());
        id++;
    }
    String greetingText = "Здравствуйте, наконец-то этот день настал и" +
            " мы начинаем новый розыгрыш!";

    @Override
    public void startNewDrawing(List<ToyBaseModel> toys) {
        Random random = new Random();
        System.out.println(greetingText);
        if (toys.isEmpty()) {
            System.out.println("Пополните список игрушек!");
        } else {
            while (!toys.isEmpty()) {
                for (int i = 0; i < toys.size(); i++) {
                    int totalChance = random.nextInt(0, 100);
                    for (ToyBaseModel toy : toys) {
                        if (totalChance < toy.getChance()) {
                            System.out.println(toy.getName());
                            toys.remove(toy);
                            break;
                        }
                    }
                }
            }
            System.out.println("Розыгрыш завершен!");
        }


    }

    @Override
    public String toString() {
        return String.format("Розыгрыш №: %d - %s",id, date);
    }

    @Override
    public void addedDrawingToys(List<ToyBaseModel> toys, ToyBaseModel toy) {
        toys.add(toy);
    }

    @Override
    public void removeDrawingToys(List<ToyBaseModel> toys, ToyBaseModel toy) {
        toys.remove(toy);
    }

}
