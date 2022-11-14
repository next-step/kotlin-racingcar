package study.racingcar.car

class Car {
    var currentLocation: Int = INIT_LOCATION
        private set

    fun move(power: Int) {
        if (canMove(power)) {
            currentLocation += 1
        }
    }

    private fun canMove(power: Int): Boolean {
        return power >= FORWARD_NUMBER
    }

    companion object {
        private const val FORWARD_NUMBER = 4
        private const val INIT_LOCATION = 1
    }
}
