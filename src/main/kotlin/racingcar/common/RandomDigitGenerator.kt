package racingcar.common

object RandomDigitGenerator {

    val DIGIT_RANGE = 0..9

    fun nextCommand(): Int {
        return DIGIT_RANGE.random()
    }
}
