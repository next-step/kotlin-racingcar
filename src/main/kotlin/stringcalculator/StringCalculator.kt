package stringcalculator

import java.lang.IllegalArgumentException

class StringCalculator() {

    private val DELIMITER = " "

    fun calculate(input: String): Int {
        inputValidate(input)

        val splitInput = input.split(DELIMITER)

        var total = splitInput.first().toInt()

        for (index in 1..splitInput.lastIndex step 2) {
            val operator = splitInput[index]
            val operand = splitInput[index + 1].toInt()

            val operation = Operation.of(operator)
            total = operation.calculate(total, operand)
        }

        return total
    }

    private fun inputValidate(input: String?) {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("빈값이나 null은 허용되지 않습니다")
        }
    }
}
