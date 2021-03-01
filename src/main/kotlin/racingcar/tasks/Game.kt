package racingcar.tasks

import racingcar.model.Car
import racingcar.ui.OutputView
import racingcar.viewmodel.GameViewModel

class Game {

    fun run(listOfCar: List<Car>) {
        GameViewModel.tryGo(listOfCar).mapIndexed { index, car ->
            OutputView.getResult(index == listOfCar.lastIndex, car)
        }
    }

    fun setRacingCar(countOfCar: Int): List<Car> {
        return (0 until countOfCar).map { Car.createCar() }
    }
}
