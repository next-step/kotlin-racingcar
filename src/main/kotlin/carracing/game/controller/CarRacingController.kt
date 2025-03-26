package carracing.game.controller

import carracing.game.domain.CarRacingModel
import carracing.game.view.CarRacingView
import carracing.game.view.ErrorView
import carracing.game.view.InputView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking

class CarRacingController {
    private val inputView = InputView()
    private val errorView = ErrorView()
    private val carRacingView = CarRacingView()

    private val model = CarRacingModel()

    fun startGame() {
        getGameParameters()
        startRacing()
    }

    private fun getGameParameters() {
        getCarsParameter()
        getRoundsParameter()
    }

    private fun getCarsParameter() {
        while (true) {
            try {
                model.assignCarsAmount(inputView.inquireCarsAmount())
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
        runBlocking {
            try {
                model.getRaceFlow().collectLatest {
                    carRacingView.printCurrentRaceState(it)
                }
            } catch (ex: IllegalArgumentException) {
                ex.message?.let { errorView.printError(it) }
                startGame()
            }
        }
}
