package model;

import java.util.List;

public abstract class RaffleBaseModel {


    public abstract void startNewRaffle(List<ToyBaseModel> toys, List<ToyBaseModel> drawingsToysList);

    public abstract List<ToyBaseModel> getToyList();
}
