package Models.Interfaces;

public interface IGameboard
{

    void place_figure(IGameFigure figure, int x, int y);

    void clear_gameboard();

    IGameFigure[][] getGameboard();

    IGameFigure[][] setGameboard();

    boolean isPlayable();

}
