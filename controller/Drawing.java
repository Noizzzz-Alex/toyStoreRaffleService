package controller;

import model.AddDrawingToys;
import model.NewDrawing;
import model.ToyBaseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Drawing implements NewDrawing, AddDrawingToys {
    String greetingText = "Здравствуйте, наконец-то этот день настал и" +
            "мы начинаем новый розыгрыш!";
    List<ToyBaseModel> drawingsToys = new ArrayList<>();

    @Override
    public void startNewDrawing() {
        Random random = new Random();
        System.out.println(greetingText);
        if (!drawingsToys.isEmpty()) {
            for (int i = 0; i < drawingsToys.size(); i++) {
                int temp = random.nextInt(0, 100);
                for (ToyBaseModel toy : drawingsToys) {
                    if (temp <= toy.getChance()) {
                        System.out.println(toy.getName());
                        break;
                    }
                }
            }
        } else {
            System.out.println("Список игрушек для розыгрыша пуст!");
        }

    }

    @Override
    public void addedDrawingToys(ToyBaseModel toy) {
        this.drawingsToys.add(toy);
    }
}
