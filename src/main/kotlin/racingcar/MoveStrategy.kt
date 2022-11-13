package racingcar

private const val START_DIGIT: Int = 0
private const val MEDIAN_DIGIT: Int = 4
private const val END_DIGIT: Int = 9

open class MoveStrategy(
    private val baseNumber: Int = MEDIAN_DIGIT,
    private val range: IntRange = IntRange(START_DIGIT, END_DIGIT)
) {

    fun canMove(randomNumber: Int = range.random()): Boolean {
        return randomNumber >= baseNumber
    }
}
