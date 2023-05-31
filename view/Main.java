package view;

import controller.Console;
import controller.IdGenerator;
import controller.ToyRobot;
import model.ConsoleBaseModel;

public class Main {
    public static void main(String[] args) {
        ToyRobot toyRobot = new ToyRobot("Robot", 60);
        System.out.println(toyRobot);
    }
//        ConsoleBaseModel console = new Console();
//        console.start();
//        IdGenerator idGenerator = new IdGenerator();
//        System.out.println(idGenerator.generateId("ABCDEFGHIJKLMNOPQRSTUVWXYZ",4));
}

