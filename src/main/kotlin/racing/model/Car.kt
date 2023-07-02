package racing.model

class Car {
    val CAR_SYMBOL = "-"
    private var position: Int = 0
    fun run(): Int {
        val randomNumber: Int = (RANDOM_MIN_NUMBER..RANDOM_MAX_NUMBER).random()
        if (randomNumber >= LIMIT_ADVANCE) position++
        return position
    }

    companion object {
        private const val RANDOM_MIN_NUMBER: Int = 0
        private const val RANDOM_MAX_NUMBER: Int = 9
        private const val LIMIT_ADVANCE: Int = 4
    }
}
