package racingcar.service

import racingcar.domain.Cars

class Race(registerCarNumber: Int, private val moveCarNumber: Int) {

    val cars = Cars(registerCarNumber)

    fun confirmMoveOfCars(carMovingStrategy: Boolean) {
        for (index in CAR_MOVE_LOOP_START_NUMBER..moveCarNumber)
            cars.moveOfCars(carMovingStrategy)
    }

    companion object {
        private const val CAR_MOVE_LOOP_START_NUMBER = 1
    }
}
