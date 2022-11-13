package racingcar.racingcar

class Indicator(
    private val indicators: List<Int>
) {
    fun current(turn: Int): Int {
        return indicators[turn - 1]
    }
}
