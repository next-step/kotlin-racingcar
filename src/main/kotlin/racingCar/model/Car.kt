package racingCar.model

import racingCar.conditionOfMove

data class Car(val mileage: Int = 0) {

    fun move(move: Int) = when (conditionOfMove(move)) {
        true -> forward()
        false -> stop()
    }

    private fun forward() = copy(mileage = this.mileage + 1)
    private fun stop() = copy(mileage = this.mileage)

}
