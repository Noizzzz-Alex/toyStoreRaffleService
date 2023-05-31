package model;

public abstract class ConsoleBaseModel {
    public abstract   void  start();
    protected abstract void mainMenu();
    protected abstract void subMenuDrawing(NewDrawing newDrawing);
    protected abstract void subMenuAddedToysForDrawing(NewDrawing newDrawing);

}
