package racingcar.domain

class Race(registerCarNumber: Int, private val moveCarNumber: Int) {

    val cars = Cars(registerCarNumber)

    fun confirmMoveOfCars(carMovingStrategy: MovingStrategy) {
        for (index in CAR_MOVE_LOOP_START_NUMBER..moveCarNumber)
            cars.moveOfCars(carMovingStrategy)
    }

    companion object {
        private const val CAR_MOVE_LOOP_START_NUMBER = 1
    }
}
