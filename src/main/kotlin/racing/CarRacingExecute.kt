package racing

import racing.domain.CarRacing
import racing.dto.Car
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

        val cars: List<Car> = carRacing.createCars(carNames)
        carRacing.moveCars(cars = cars, moveCount = moveCount)

        CarRacingResultView.printCarRacingResult(cars = cars, moveCount = moveCount)

        val winners: Winners = carRacing.pickWinners(cars)
        CarRacingResultView.printWinners(winners = winners)
    }
}