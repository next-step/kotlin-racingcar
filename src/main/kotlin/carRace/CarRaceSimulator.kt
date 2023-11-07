package carRace

import carRace.domain.CarMovingStrategy
import carRace.domain.CarRaceResult
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

        val carRaceResult = CarRaceResult(carList)

        repeat(iterationCount) {
            carRaceResult.currentCars.forEach { car ->
                car.drive()
            }
            carRaceResult.updateHistory(it + 1)
        }

        resultView.printResult(carRaceResult)
        return carRaceResult
    }
}

fun main() {
    CarRaceSimulator(UserInputView()).simulate()
}
