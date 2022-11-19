package racingcarWinner.controller

import racingcarWinner.domain.CarRacing
import racingcarWinner.domain.Cars
import racingcarWinner.domain.Winner
import racingcarWinner.ui.InputView
import racingcarWinner.ui.OutputView

class CarRacingController {
    fun startRacing() {
        val carNameList = InputView.inputCarNames()
        val tryNumber = InputView.inputTryNumber()

        val cars = Cars(carNameList)

        OutputView.outputResult()
        for (i in InputView.INIT_TRY_NUMBER..tryNumber) {
            OutputView.printTryOneRacingOutput(CarRacing.startRacing(cars.carList))
        }

        OutputView.outputWinner(Winner.getWinner(cars))
    }
}
