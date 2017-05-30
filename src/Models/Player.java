package Models;

import Models.Enums.PlayerRole;
import Models.Interfaces.IGameFigure;
import Models.Interfaces.IGameboard;
import Models.Interfaces.IPlayer;

import java.util.ArrayList;

public class Player implements IPlayer
{
    //private IGameFigure[]  _figures;
    private String name;
    protected IGameFigure figure;

    public Player(PlayerRole role, String name)
    {

        /*for (int i = 0; i > 3; i++)
        {*/
            if (role == PlayerRole.Circle)
            {
                //figures.add(new CircleFigure());
                this.figure = new CircleFigure();
            }
            else if (role == PlayerRole.Cross)
            {
                //figures.add(new CrossFigure());
                this.figure = new CrossFigure();
            }
        //}
        //this._figures = (IGameFigure[])figures.toArray();
        this.name = name;
    }


    @Override
    public String place_figure()
    {
        return this.figure.draw();
    }

    public String getName()
    {
        return this.name;
    }

    public IGameFigure getFigure() {
        return this.figure;
    }
}
