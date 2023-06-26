package model;

import controller.IdGenerator;

public abstract class ToyBaseModel{
    IdGenerate generator = new IdGenerator();
    protected String id;
    protected String name;
    protected int chance;
    {
        id = generator.generateId(4,4);
    }


    public String getName() {
        return name;
    }

    public int getChance() {
        return chance;
    }

    public ToyBaseModel(String name, int chance) {
        this.name = name;
        this.chance = chance;
    }

    @Override
    public String toString() {
        return String.format("|id: %9s | name: %-10s|", id, name);
    }
}
