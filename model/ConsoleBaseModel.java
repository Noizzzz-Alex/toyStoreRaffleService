package model;

import java.util.List;

public abstract class ConsoleBaseModel {
    List<DrawingBaseModel>drawingList;
    public abstract   void  start();
    public abstract void mainMenu();
    protected abstract void subMenuDrawing(DrawingBaseModel newDrawing);
    protected abstract void subMenuAddedToysForDrawing(DrawingBaseModel newDrawing);

}
