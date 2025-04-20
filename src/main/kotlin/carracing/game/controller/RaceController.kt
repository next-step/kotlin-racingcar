package carracing.game.controller

import carracing.game.domain.data.Race
import carracing.game.view.CarRacingView

class RaceController(
    private val race: Race,
    private val carRacingView: CarRacingView = CarRacingView(),
) {
    fun startRace() {
        generateRaceProgress()
        showWinners()
    }

    private fun generateRaceProgress() {
        race.generateRaceSequence().forEach {
            carRacingView.printCurrentRaceState(it)
        }
    }

    private fun showWinners() {
        val winners = race.winners
        carRacingView.printWinners(winners.map { it.name })
    }
}
