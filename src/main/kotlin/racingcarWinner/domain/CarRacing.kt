package racingcarWinner.domain

import racingcarWinner.util.MessageCode
import racingcarWinner.util.Util

class CarRacing(carNames: List<String>) {
    private val carList: List<Car> = carNames.map { Car(it.trim()) }

    init {
        require(carList.count() > MIN_CAR_NUMBER) { MessageCode.CarNumberException.message }
    }

    fun getCarList(): List<Car> = carList

    fun startRacing(): List<Car> =
        carList.map { car ->
            car.move(Util.getRandomNumber())
            car
        }

    companion object {
        const val MIN_CAR_NUMBER = 1
    }
}
