package step2

/**
 * 문자열 사칙 연산 계산기
 * Created by Jaesungchi on 2022.05.05..
 */

fun main() {
    val calculator = StringCalculator()
    val input = readlnOrNull()
    val output = calculator.startCalculate(input)
    println(output)
}

class StringCalculator {
    /**
     * 문자열을 받고 계산을 시작하여 계산한값을 돌려준다.
     */
    fun startCalculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(ErrorMessage.IS_NULL_OR_BLANK)
        }

        val inputList = splitByDelimiter(input)
        if (inputList.size % EVEN_COMPARISON_NUMBER == RESULT_WHEN_EVEN_NUMBER) {
            throw IllegalArgumentException(ErrorMessage.NOT_MATCH_OPERATORS_AND_OPERANDS)
        }

        // 첫숫자는 바로 계산하기 위해 저장한다.
        var output = changeStringToInt(inputList.first())
        for (index in NUMBER_OF_EXCLUDING_THE_FIRST_INDEX until inputList.size step SIZE_OF_CALCULATION_UNIT) {
            output =
                calculateByOperator(inputList[index], output, changeStringToInt(inputList[index + INDEX_OF_NUMBER]))
        }

        return output
    }

    /**
     * 문자열을 스페이스로 나눠 List로 돌려주는 메소드.
     */
    private fun splitByDelimiter(input: String): List<String> {
        return input.split(DELIMITER)
    }

    /**
     * 계산가능한 숫자인지 확인하는 메소드.
     */
    private fun changeStringToInt(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.IS_NON_DIGIT_CHARACTER)
    }

    /**
     * Operator에 따라 계산한다.
     */
    private fun calculateByOperator(operator: String, operand1: Int, operand2: Int): Int {
        return when (Operator.of(operator)) {
            Operator.PLUS -> operand1 + operand2
            Operator.MINUS -> operand1 - operand2
            Operator.MULTIPLY -> operand1 * operand2
            Operator.DIVISION -> operand1 / operand2
        }
    }

    companion object {
        private const val DELIMITER = " "

        private const val EVEN_COMPARISON_NUMBER = 2
        private const val RESULT_WHEN_EVEN_NUMBER = 0

        private const val NUMBER_OF_EXCLUDING_THE_FIRST_INDEX = 1
        private const val SIZE_OF_CALCULATION_UNIT = 2

        private const val INDEX_OF_NUMBER = 1
    }
}
