package calculator.domain

const val SPACE_DELIMITER = " "

class Calculator(private val delimiter: String = SPACE_DELIMITER) {
    fun calculate(input: String): Double {
        val tokens = input.split(delimiter)
        return Expression(tokens).execute().number
    }
}
