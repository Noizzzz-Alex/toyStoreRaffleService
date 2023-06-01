package view;

import controller.Console;
import controller.Drawing;
import controller.IdGenerator;
import controller.ToyRobot;
import model.ConsoleBaseModel;
import model.NewDrawing;

public class Main {
    public static void main(String[] args) {
        ToyRobot toyRobot = new ToyRobot("Robot", 60);
        Drawing drawing = new Drawing();
        drawing.addedDrawingToys(toyRobot);
    }
//        ConsoleBaseModel console = new Console();
//        console.start();
//        IdGenerator idGenerator = new IdGenerator();
//        System.out.println(idGenerator.generateId("ABCDEFGHIJKLMNOPQRSTUVWXYZ",4));
}

