package Models;

import Models.Enums.PlayerRole;
import Models.Interfaces.IGameFigure;
import Models.Interfaces.IGameboard;
import Models.Interfaces.IPlayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Gameboard implements IGameboard, Serializable
{

    protected IGameFigure[][] gameboard;
    //protected List<Player> players = new ArrayList<>(2);
    protected boolean playable = true;
    protected Player currentPlayer;
    protected Player player1;
    protected Player player2;

    public Gameboard()
    {
        this.gameboard = new IGameFigure[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {

                this.gameboard[x][y] = new IGameFigure() {
                    @Override
                    public String draw() {
                        return "N/A";
                    }
                };
            }
        }



        //this.players.add(new Player(PlayerRole.Cross, "Player one"));
        //this.players.add(new Player(PlayerRole.Circle, "Player two"));
        this.player1 = new Player(PlayerRole.Cross, "Player one");
        this.player2 = new Player(PlayerRole.Circle, "Player two");
        this.currentPlayer = this.player1;

    }

    @Override
    public void place_figure(IGameFigure figure, int x, int y)
    {
        if (this.gameboard[x][y].draw() == "N/A" && this.isPlayable())
        {
            this.gameboard[x][y] = figure;
            if (this.currentPlayer == this.player1)
            {
                this.currentPlayer = this.player2;
            }
            else if (this.currentPlayer == this.player2)
            {
                this.currentPlayer = this.player1;
            }
        }
    }

    @Override
    public void clear_gameboard()
    {
        this.gameboard = new IGameFigure[3][3];
    }

    @Override
    public IGameFigure[][] getGameboard()
    {
        return this.gameboard;
    }

    @Override
    public IGameFigure[][] setGameboard()
    {
        this.gameboard = new IGameFigure[3][3];
        return this.gameboard;
    }

    @Override
    //Returns true if the placement on the gameboard
    // means that a winner will never be found,
    // or the players have used all their available figures
    public boolean isPlayable()
    {
        List<Combination> combinations = new ArrayList<>();
        // horizontal
        for (int y = 0; y < 3; y++) {
            combinations.add(new Combination(this.gameboard[0][y], this.gameboard[1][y], this.gameboard[2][y]));
        }

        // vertical
        for (int x = 0; x < 3; x++) {
            combinations.add(new Combination(this.gameboard[x][0], this.gameboard[x][1], this.gameboard[x][2]));
        }

        // diagonals
        combinations.add(new Combination(this.gameboard[0][0], this.gameboard[1][1], this.gameboard[2][2]));
        combinations.add(new Combination(this.gameboard[2][0], this.gameboard[1][1], this.gameboard[0][2]));
        for (Combination combo : combinations) {
            if (combo.isComplete()) {
                playable = false;
                break;
            }
        }
        return playable;
    }

    public Player getCurrentPlayer()
    {
        return this.currentPlayer;
    }

}
