package racingcar.common

object RandomDigitGenerator {

    val DIGIT_RANGE = 0..9

    fun nextDigit(): Int {
        return DIGIT_RANGE.random()
    }
}
