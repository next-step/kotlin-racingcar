package racingcar.service

import racingcar.domain.Cars
import racingcar.domain.MovingStrategy

class Race(registerCarName: String, private val moveCarNumber: Int) {

    val cars = Cars(registerCarName)

    fun confirmMoveOfCars(movingStrategy: MovingStrategy) {
        repeat(moveCarNumber) {
            cars.moveOfCars(movingStrategy)
        }
    }
}
