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

    fun setRacingCar(infoOfCars: List<String>): List<Car> {
        return infoOfCars.map { name ->
            Car.create(name)
        }
    }
}
