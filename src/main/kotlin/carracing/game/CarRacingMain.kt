package carracing.game

import carracing.game.controller.RaceController
import carracing.game.controller.RaceParametersController

fun main() {
    val raceParamsController = RaceParametersController()
    val race = raceParamsController.setRaceParameters()
    val raceController = RaceController(race)
    raceController.startRace()
}
