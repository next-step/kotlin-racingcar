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
        if (input.isNullOrBlank()) throw IllegalArgumentException("Input is Null or Blank.")

        val inputList = splitStringBySpace(input)
        if (inputList.size % 2 == 0) throw IllegalArgumentException("The number of operators and operands does not match.")

        //첫숫자는 바로 계산하기 위해 저장한다.
        var output = checkEnabledNumber(inputList.first())
        for (index in 1 until inputList.size step 2) {
            output =
                calculateByOperator(Operator.of(inputList[index]), output, checkEnabledNumber(inputList[index + 1]))
        }

        return output
    }

    /**
     * 문자열을 스페이스로 나눠 List로 돌려주는 메소드.
     */
    private fun splitStringBySpace(input: String): List<String> {
        return input.split(" ")
    }

    /**
     * 계산가능한 숫자인지 확인하는 메소드.
     */
    private fun checkEnabledNumber(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("There is a non-digit character in the digit position.")
    }

    /**
     * Operator에 따라 계산한다.
     */
    private fun calculateByOperator(operator: Operator, operand1: Int, operand2: Int): Int {
        return when (operator) {
            Operator.PLUS -> operand1 + operand2
            Operator.MINUS -> operand1 - operand2
            Operator.MULTIPLY -> operand1 * operand2
            Operator.DIVISION -> operand1 / operand2
        }
    }
}