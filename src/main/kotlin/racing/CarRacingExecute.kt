package racing

import racing.domain.CarRacing
import racing.dto.Winners
import racing.view.CarRacingInputView
import racing.view.CarRacingResultView

fun main() {
    CarRacingExecute().startRacing()
}

class CarRacingExecute {
    private val carRacing = CarRacing()

    fun startRacing() {
        val (carNames, moveCount) = CarRacingInputView.input()
        carNames.forEach { carRacing.checkCarNameLength(carName = it) }

        carRacing.moveCars(moveCount = moveCount)

        CarRacingResultView.printCarRacingResult(cars = carRacing.cars, moveCount = moveCount)

        val winners = Winners(cars = carRacing.cars).pickWinners()
        CarRacingResultView.printWinners(winners = winners)
    }
}
