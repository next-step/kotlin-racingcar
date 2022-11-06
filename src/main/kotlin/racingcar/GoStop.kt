package racingcar

class GoStop(private val baseNumber: Int = 4, private val range: IntRange = IntRange(0, 9)) {

    fun canGo(randomNumber: Int = range.random()): Boolean {
        return randomNumber >= baseNumber
    }
}
