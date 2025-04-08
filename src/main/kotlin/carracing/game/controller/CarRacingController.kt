package carracing.game.controller

import carracing.game.domain.CarRacingModel
import carracing.game.view.CarRacingView
import carracing.game.view.ErrorView
import carracing.game.view.InputView

class CarRacingController(
    private val inputView: InputView = InputView(),
    private val errorView: ErrorView = ErrorView(),
    private val carRacingView: CarRacingView = CarRacingView(),
    private val model: CarRacingModel = CarRacingModel(),
) {
    fun startGame() {
        getGameParameters()
        startRacing()
        showWinners()
    }

    private fun getGameParameters() {
        getCarsParameter()
        getRoundsParameter()
    }

    private fun getCarsParameter() {
        while (true) {
            try {
                model.assignCars(inputView.inquireCarsNames())
                return
            } catch (e: IllegalArgumentException) {
                e.message?.let { errorView.printError(it) }
            }
        }
    }

    private fun getRoundsParameter() {
        while (true) {
            try {
                model.assignRoundsAmount(inputView.inquireRoundsAmount())
                return
            } catch (e: IllegalArgumentException) {
                e.message?.let { errorView.printError(it) }
            }
        }
    }

    private fun startRacing() =
        try {
            model.getRaceSequence().forEach {
                carRacingView.printCurrentRaceState(it)
            }
        } catch (ex: IllegalArgumentException) {
            ex.message?.let { errorView.printError(it) }
            startGame()
        }

    private fun showWinners() {
        try {
            val winners = model.defineWinners()
            carRacingView.printWinners(winners.map { it.name })
        } catch (ex: IllegalArgumentException) {
            ex.message?.let { errorView.printError(it) }
            startGame()
        }
    }
}
