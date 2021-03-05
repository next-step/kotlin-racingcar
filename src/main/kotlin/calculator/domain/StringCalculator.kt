package calculator.domain

const val SPACE_DELIMITER = " "

class StringCalculator(private val delimiter: String = SPACE_DELIMITER) {
    fun calculate(input: String): Double {
        val tokens = input.split(delimiter)
        return Calculator(tokens).execute().number
    }
}
