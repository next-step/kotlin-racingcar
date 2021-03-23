package car

import car.domain.CarNames
import car.domain.Cars
import car.domain.history.CarMoveHistories
import car.domain.winner.Winners
import car.view.InputView
import car.view.ResultView

fun main() {
    val inputView = InputView()

    val names = inputView.inputNames()
    val tryCount = inputView.inputTryCount()
    val prettyString = inputView.inputPrettyString()

    val carNames = CarNames(names.splitNameBySplitter())
    val cars = Cars(carNames)

    val allCarMoveHistories = mutableListOf<CarMoveHistories>()
    repeat(tryCount.count) {
        cars.move()
        allCarMoveHistories.add(cars.currentMoveHistories)
    }

    val winners: Winners = Winners(cars)

    val resultView = ResultView()

    resultView.print(allCarMoveHistories, tryCount, prettyString)
    resultView.printWinners(winners)
}
