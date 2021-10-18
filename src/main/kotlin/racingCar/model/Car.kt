package racingCar.model

import racingCar.conditionOfMove

data class Car(var mileage: Int = 0) {

    fun move(move: () -> Int) = when (conditionOfMove(move.invoke())) {
        true -> forward()
        false -> stop()
    }

    private fun forward() {
        mileage = ForwardStrategy().move(mileage)
    }

    private fun stop() {
        mileage = StopStrategy().move(mileage)
    }
}
