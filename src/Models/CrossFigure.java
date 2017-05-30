package Models;

import Models.Interfaces.IGameFigure;

/**
 * Created by kenneth on 23/05/2017.
 */
public class CrossFigure implements IGameFigure {
    @Override
    public String draw()
    {
        return "X";
    }
}
