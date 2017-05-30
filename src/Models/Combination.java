package Models;

import Models.Interfaces.IGameFigure;

public class Combination
{
    private IGameFigure[] figures;
    public Combination(IGameFigure... figures) {
        this.figures = figures;
    }

    public boolean isComplete() {
        boolean is_nulled = false;
        for (IGameFigure figure:this.figures)
        {
            if (figure.draw() == "N/A")
            {
                is_nulled = true;
            }
        }
        if(!is_nulled)
        {
            /*if (this.figures[0] == null)
                return false;*/

            return this.figures[0].getClass().equals(this.figures[1].getClass())
                    && this.figures[0].getClass().equals(this.figures[2].getClass());
        }
        return false;
    }
}
