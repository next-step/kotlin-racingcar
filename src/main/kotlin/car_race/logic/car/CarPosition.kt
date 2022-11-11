package car_race.logic.car

data class CarPosition(
    private var value: Int = 0
) {
    fun nextRound() {
        val randomNum = DICE_RANGE.random()
        value += if (randomNum >= DIVIDE_NUMBER) 1 else 0
    }

    fun getValue() = value

    companion object {
        private val DICE_RANGE = (0..9)
        private const val DIVIDE_NUMBER = 4
    }
}
