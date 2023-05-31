package model;

import controller.IdGenerator;

abstract class ToyBaseModel{
    String id;
    String name;
    int chance;

    public ToyBaseModel(String id, String name, int chance) {
        this.id = id;
        this.name = name;
        this.chance = chance;
    }

    @Override
    public String toString() {
        return String.format("|id: %9s | name: %10s|", id, name);
    }
}
