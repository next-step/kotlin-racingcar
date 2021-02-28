package study.racingcar

import kotlin.random.Random

class RacingGame {

    private lateinit var _cars: Array<Car>
    val cars: Array<Car> get() = _cars

    fun readyGame(carCount: Int) {
        _cars = Array(carCount) { Car() }
    }

    fun raceCars(): List<Car> {
        for (car in _cars) {
            val randomValue = Random.nextInt(9)
            moveCarOrNot(randomValue, car)
        }
        return _cars.toList()
    }

    fun moveCarOrNot(randomValue: Int, car: Car) {
        if (randomValue >= MOVE_ALLOWABLE_VALUE) {
            car.moveCar()
        }
    }

    companion object {
        private const val MOVE_ALLOWABLE_VALUE = 4
    }
}
