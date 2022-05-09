package step3.racingcar.car

import step3.racingcar.RandomNumberGenerator

class Driver(
    private val car: Car
) {

    fun drive() {
        if (isMovable(RandomNumberGenerator.generate())) {
            car.move()
        } else {
            car.stop()
        }
    }

    fun getDriveResult(): List<Position> {
        return car.getDrivingRecord()
    }

    fun isMovable(moveNumber: Int): Boolean {
        return moveNumber >= DRIVE_DEFINE_NUMBER
    }

    companion object {
        private const val DRIVE_DEFINE_NUMBER = 4
    }
}
