package racingcar.viewmodel

import racingcar.model.Car
import racingcar.util.RacingRandom

object GameViewModel {
    fun tryGo(listOfCar: List<Car>): List<Car> {
        return listOfCar.asSequence()
            .map { car ->
                car.apply {
                    tryMove(RacingRandom.canGo())
                }
            }.toList()
    }
}
