package racingcar.domain

class Car {
    var position: Int = 0
        private set

    fun tryMove(conditionNumber: Int) {
        if (CarConfig.MOVE_PERCENTAGE <= conditionNumber) {
            position++
        }
    }
}
