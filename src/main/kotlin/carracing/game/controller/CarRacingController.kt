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
        var carsAmountInput: String? = inputView.inquireCarsAmount()
        while (!model.assignCarsAmount(carsAmountInput)) {
            errorView.printError("Cars amount should be an integer")
            carsAmountInput = inputView.inquireCarsAmount()
        }
    }

    private fun getRoundsParameter() {
        var roundsAmountInput: String? = inputView.inquireRoundsAmount()
        while (!model.assignRoundsAmount(roundsAmountInput)) {
            errorView.printError("Rounds amount should be an integer")
            roundsAmountInput = inputView.inquireRoundsAmount()
        }
    }

    private fun startRacing() =
        runBlocking {
            try {
                model.getRaceFlow().collectLatest {
                    carRacingView.printCurrentRaceState(it)
                }
            } catch (ex: IllegalArgumentException) {
                errorView.printError("Initial race values were not initialized")
                startGame()
            }
        }
}
