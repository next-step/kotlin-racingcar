package racingcar

const val START_DIGIT: Int = 0
const val MEDIAN_DIGIT: Int = 4
const val END_DIGIT: Int = 9

class Movable(
    private val baseNumber: Int = MEDIAN_DIGIT,
    private val range: IntRange = IntRange(START_DIGIT, END_DIGIT)
) {

    fun canGo(randomNumber: Int = range.random()): Boolean {
        return randomNumber >= baseNumber
    }
}
