package racingcar.service

import racingcar.domain.Cars
import racingcar.domain.MovingStrategy

class Race(registerCarNumber: Int, private val moveCarNumber: Int) {

    val cars = Cars(registerCarNumber)

    fun confirmMoveOfCars(movingStrategy: MovingStrategy) {
        repeat(moveCarNumber) {
            cars.moveOfCars(movingStrategy)
        }
    }
}
