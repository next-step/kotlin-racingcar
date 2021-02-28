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
            car.moveCar(Random.nextInt(9))
        }
        return _cars.toList()
    }
}
