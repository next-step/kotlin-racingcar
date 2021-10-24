package step3

data class Distance(val default: Int = DEFAULT_NUMBER_OF_COUNT) {
    fun calculate() = (MIN_DISTANCE..MAX_DISTANCE).random()
}

const val MIN_DISTANCE = 0
const val MAX_DISTANCE = 9
