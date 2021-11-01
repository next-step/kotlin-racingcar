package racingcar.service

import racingcar.domain.Cars

class Race(registerCarNumber: Int, private val moveCarNumber: Int) {

    val cars = Cars(registerCarNumber)

    fun confirmMoveOfCars(carMovingStrategy: Boolean) {
        repeat(moveCarNumber) {
            cars.moveOfCars(carMovingStrategy)
        }
    }
}
