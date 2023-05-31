package view;

import controller.IdGenerator;

public class Main {
    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator();

        System.out.println(idGenerator.generateId("ABCDEFGHIJKLMNOPQRSTUVWXYZ",4));
    }
}
