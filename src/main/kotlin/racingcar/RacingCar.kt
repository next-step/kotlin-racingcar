package racingcar

class RacingCar(val name: String, position: Int = DEFAULT_POSITION_NUMBER) {

    var position: Int = position
        private set

    fun tryMove(number: Int) =
        when (number) {
            in FORWARD_POWER_NUMBER..MAXIMUM_POWER_NUMBER -> position++
            else -> position
        }

    companion object {
        const val MINIMUM_POWER_NUMBER = 0
        const val MAXIMUM_POWER_NUMBER = 9
        const val FORWARD_POWER_NUMBER = 4
        const val DEFAULT_POSITION_NUMBER = 0
    }
}
