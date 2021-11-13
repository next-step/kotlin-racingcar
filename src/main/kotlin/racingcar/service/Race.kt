package racingcar.service

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.MovingStrategy

class Race(registerCarNames: String, private val moveCarNumber: Int) {

    val cars = Cars(registerCarNames)

    fun findWinner(): List<Car> {
        return cars.winners()
    }

    fun confirmMoveOfCars(movingStrategy: MovingStrategy) {
        repeat(moveCarNumber) {
            cars.moveOfCars(movingStrategy)
        }
    }
}
