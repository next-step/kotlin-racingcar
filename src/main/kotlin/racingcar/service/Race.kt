package racingcar.service

import racingcar.domain.Cars
import racingcar.domain.MovingStrategy

class Race(registerCarNames: String, private val moveCarNumber: Int) {

    val cars = Cars(registerCarNames)

    fun findWinner(): List<String> {
        return cars.winners()
    }

    fun confirmMoveOfCars(movingStrategy: MovingStrategy) {
        repeat(moveCarNumber) {
            cars.moveOfCars(movingStrategy)
        }
    }
}
