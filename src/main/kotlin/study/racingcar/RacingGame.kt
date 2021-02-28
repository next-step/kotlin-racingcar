package study.racingcar

import kotlin.random.Random

class RacingGame(private val moveStrategy: MoveStrategy) {

    private lateinit var _cars: Array<Car>
    val cars: Array<Car> get() = _cars

    fun readyGame(carCount: Int) {
        _cars = Array(carCount) { Car() }
    }

    fun raceCars(): List<Car> {
        for (car in _cars) {
            moveCarOrNot(car)
        }
        return _cars.toList()
    }

    fun moveCarOrNot(car: Car) {
        if (moveStrategy.isMoveCar(Random.nextInt(9))) {
            car.moveCar()
        }
    }
}
