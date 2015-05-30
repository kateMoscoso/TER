package ticTacToe;

import utils.CoordenadaTester;
import ticTacToe.models.TurnoTester;
import ticTacToe.models.TableroTester;
import utils.CoordenadaViewTester;
import ticTacToe.views.TurnoViewTester;

public class TicTacToeUnitTester {

    public void test() {
        CoordenadaTester.main(null);
        TurnoTester.main(null);
        TableroTester.main(null);
        CoordenadaViewTester.main(null);
        TurnoViewTester.main(null);
    }
}
