package step3.domain

import step3.data.RacingCar

object MoveCourse {
    fun moveCourse(car: RacingCar, isMoveSuccess: Boolean) {
        if (isMoveSuccess) {
            car.moveCount += 1
        }
    }
}
