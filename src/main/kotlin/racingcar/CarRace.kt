package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.move.MovingStrategy
import racingcar.domain.move.RandomMovingStrategy
import racingcar.dto.CarSnapshot
import racingcar.view.ConsoleInput
import racingcar.view.ConsoleOutput
import racingcar.view.InputView
import racingcar.view.OutputView

class CarRace(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val movingStrategy = RandomMovingStrategy()
        val countOfCars = inputView.askCountOfCars()
        val cars = Cars(List(countOfCars) { Car() })
        val countOfTrial = inputView.askCountOfTrial()
        println("실행결과")
        for (i in 0 until countOfTrial) {
            takeOneTrial(cars, movingStrategy)
        }
    }

    private fun takeOneTrial(cars: Cars, movingStrategy: MovingStrategy) {
        cars.move(movingStrategy)
        val snapshots = cars.values.map(::CarSnapshot).toList()
        outputView.printCarPositions(snapshots)
        println()
    }
}

fun main() {
    val carRace = CarRace(ConsoleInput(), ConsoleOutput())
    carRace.run()
}
