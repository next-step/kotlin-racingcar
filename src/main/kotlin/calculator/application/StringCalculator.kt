package calculator.application

import calculator.domain.Calculator

const val SPACE_DELIMITER = " "

class StringCalculator(val delimiter: String = SPACE_DELIMITER) {
    fun calculate(input: String): Double {
        return Calculator(input.split(delimiter)).execute()
    }
}