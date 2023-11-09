package carRace

import carRace.domain.CarLapRunner
import carRace.domain.CarMovingStrategy
import carRace.domain.CarRaceResult
import carRace.domain.Cars
import carRace.domain.RandomMovingStrategy
import carRace.view.InputView
import carRace.view.ResultView
import carRace.view.UserInputView

class CarRaceSimulator(
    private val inputView: InputView,
    private val resultView: ResultView = ResultView()
) {
    fun simulate(carMovingStrategy: CarMovingStrategy = RandomMovingStrategy()): CarRaceResult {
        val carList = inputView.carsProvider.provide(carMovingStrategy)
        val iterationCount = inputView.iterationProvider.provide()

        val carRaceResult = CarRaceResult(Cars(carList))

        val carLapRunner = CarLapRunner(carRaceResult, iterationCount)

        carLapRunner.runLaps()

        resultView.printResult(carRaceResult)
        return carRaceResult
    }
}

fun main() {
    CarRaceSimulator(UserInputView()).simulate()
}
