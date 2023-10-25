package step3.domain

import step3.data.RacingCar

object MoveCourse {
    fun moveCourse(car: RacingCar) {
        if (TryMoving.isSuccessfullyMoved()) {
            car.moveCount += 1
        }
    }
}
