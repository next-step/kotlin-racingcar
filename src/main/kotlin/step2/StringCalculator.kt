package step2

import java.util.StringTokenizer

fun main() {
    println("계산식을 입력해주세요.")
    val input = readLine() ?: throw IllegalArgumentException("입력값이 없습니다.")
    println(StringCalculator.calculate(input))
}

class StringCalculator(input: String) {
    init {
        if (input.isBlank()) {
            throw IllegalArgumentException("입력 값이 비어있습니다.")
        }
        calculate(input)
    }

    companion object {
        fun add(operand1: Int, operand2: Int): Int {
            return operand1 + operand2
        }

        fun subtract(operand1: Int, operand2: Int): Int {
            return operand1 - operand2
        }

        fun multiply(operand1: Int, operand2: Int): Int {
            return operand1 * operand2
        }

        fun divide(operand1: Int, operand2: Int): Int {
            return operand1 / operand2
        }

        fun calculate(s: String) : Int {
            val st = StringTokenizer(s, " ")
            var result = validateOperand(st.nextToken())

            while (st.hasMoreTokens()) {
                val operator = st.nextToken()
                val operand = validateOperand(st.nextToken())

                result = startCalculation(operator, result, operand)
            }
            return result
        }

        private fun startCalculation(operator: String?, result: Int, operand: Int): Int = when (operator) {
            "+" -> add(result, operand)
            "-" -> subtract(result, operand)
            "*" -> multiply(result, operand)
            "/" -> divide(result, operand)
            else -> throw IllegalArgumentException("연산자가 올바르지 않습니다.")
        }

        fun validateOperand(operand: String) : Int {
            try {
                return operand.toInt()
            } catch (ex: NumberFormatException) {
                throw NumberFormatException("숫자가 아닙니다.")
            }
        }
    }
}
