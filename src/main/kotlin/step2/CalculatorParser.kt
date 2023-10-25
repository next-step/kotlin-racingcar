package step2

object CalculatorParser {
    private const val INPUT_DELIMITER = " "
    private const val OPERAND_OFFSET = 1

    fun split(input: String): List<String> = input.split(INPUT_DELIMITER)

    fun List<String>.getNextValue(operatorIndex: Int) = this[operatorIndex + OPERAND_OFFSET].toInt()
}
