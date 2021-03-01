package racingcar.viewmodel

import kotlinx.coroutines.flow.flow
import racingcar.model.Car

object GameViewModel {
    fun tryGo(listOfCar: ArrayList<Car>) = flow {
        listOfCar.map { car ->
            car.tryMove()
            emit(car)
        }
    }
}
