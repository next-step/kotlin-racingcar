package racingcar.domain.car

class Car {
    var distance: Int = 0
        private set

    fun fillGasAndForward(gas: Int) {
        if (gas >= ENOUGH_TO_FORWARD) {
            distance += FORWARD_DISTANCE
        }
    }

    companion object {
        const val ENOUGH_TO_FORWARD = 4
        const val FORWARD_DISTANCE = 1
    }
}
