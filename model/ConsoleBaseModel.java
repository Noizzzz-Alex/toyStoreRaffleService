package model;

import java.io.IOException;
import java.util.List;

public abstract class ConsoleBaseModel {
    List<RaffleBaseModel>drawingList;
    public abstract   void  start() throws IOException;
    public abstract void mainMenu() throws IOException;
    protected abstract void subMenuRaffle(RaffleBaseModel newDrawing, List<ToyBaseModel> toys);
    protected abstract void subMenuAddedToysForDrawing(RaffleBaseModel newDrawing);

}
