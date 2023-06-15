package racingcar

class RacingCar {
    var position: Int = 0
        private set

    fun tryMove(number: Int) =
        when (number) {
            in FORWARD_POWER_NUMBER..MAXIMUM_POWER_NUMBER -> position++
            else -> position
        }

    fun printPosition() {
        for (i in 0 until position) {
            print("-")
        }
        println()
    }

    companion object {
        const val MINIMUM_POWER_NUMBER = 0
        const val MAXIMUM_POWER_NUMBER = 9
        const val FORWARD_POWER_NUMBER = 4
    }
}
