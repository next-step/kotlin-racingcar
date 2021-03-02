package racingcar.viewmodel

import racingcar.model.Car
import racingcar.ui.OutputView
import racingcar.util.RacingRandom

object GameViewModel {
    fun tryGo(listOfCar: List<Car>) {
        listOfCar.mapIndexed { index, car ->
            with(car) {
                tryMove(RacingRandom.canGo())
                OutputView.getResult(index == listOfCar.lastIndex, this)
            }
        }
    }
}
