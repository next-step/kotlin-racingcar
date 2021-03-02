package racingcar.tasks

import racingcar.model.Car
import racingcar.viewmodel.GameViewModel

class Game {

    fun run(listOfCar: List<Car>) {
        GameViewModel.tryGo(listOfCar)
    }

    fun setRacingCar(countOfCar: Int): List<Car> {
        return (0 until countOfCar).map { Car.createCar() }
    }
}
