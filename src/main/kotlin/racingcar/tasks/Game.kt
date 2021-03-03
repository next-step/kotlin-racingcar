package racingcar.tasks

import racingcar.model.Car
import racingcar.ui.OutputView
import racingcar.util.RacingRandom

class Game {

    fun run(listOfCar: List<Car>) {
        listOfCar.mapIndexed { index, car ->
            with(car) {
                tryMove(RacingRandom.canGo())
                OutputView.getResult(index == listOfCar.lastIndex, this)
            }
        }
    }

    fun setRacingCar(countOfCar: Int): List<Car> {
        return (0 until countOfCar).map { Car.create() }
    }
}
