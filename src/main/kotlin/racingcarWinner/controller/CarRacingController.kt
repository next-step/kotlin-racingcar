package racingcarWinner.controller

import racingcarWinner.domain.CarRacing
import racingcarWinner.domain.Winner
import racingcarWinner.ui.InputView
import racingcarWinner.ui.OutputView

class CarRacingController {
    fun startRacing() {
        val carNameList = InputView.inputCarNames()
        val tryNumber = InputView.inputTryNumber()

        val carRacing = CarRacing(carNameList)

        OutputView.outputResult()
        for (i in InputView.INIT_TRY_NUMBER..tryNumber) {
            OutputView.printTryOneRacingOutput(carRacing.startRacing())
        }

        OutputView.outputWinner(Winner(carRacing.carList).getWinner())
    }
}
