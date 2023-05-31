package controller;

import model.NewDrawing;
import model.ToyBaseModel;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements NewDrawing {
    String greetingText = "Здравствуйте, наконец-то этот день настал и" +
            "мы начинаем новый розыгрыш!";
    List<ToyBaseModel> drawingsToys = new ArrayList<>();

    @Override
    public void startNewDrawing() {
        System.out.println(greetingText);

    }
}
