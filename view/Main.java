package view;

import controller.IdGenerator;

public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.start();
//        IdGenerator idGenerator = new IdGenerator();
//        System.out.println(idGenerator.generateId("ABCDEFGHIJKLMNOPQRSTUVWXYZ",4));
    }
}
