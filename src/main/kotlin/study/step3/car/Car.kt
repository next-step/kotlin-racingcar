package study.step3.car

class Car {
    var currentLocation: Int = INIT_LOCATION
        private set

    fun move(dice: Int) {
        if (canMove(dice)) {
            currentLocation += 1
        }
    }

    private fun canMove(dice: Int): Boolean {
        return dice >= FORWARD_NUMBER
    }

    companion object {
        private const val FORWARD_NUMBER = 4
        private const val INIT_LOCATION = 1
    }
}
