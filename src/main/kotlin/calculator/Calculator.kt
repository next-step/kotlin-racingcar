package calculator

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

class Calculator {
    fun calculate(input: String?): Double {
        validateInput(input)

        val parts = input.split(" ")
        var result = parts[0].toDouble();

        for (i in 1 until parts.size step 2) {
            val operator = parts[i]
            validateOperator(operator)

            val nextNumber = parts[i + 1].toDouble()

            result = operate(result, nextNumber, operator)
        }

        return result
    }

    /**
     * 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
     */
    @OptIn(ExperimentalContracts::class)
    private fun validateInput(input: String?) {
        contract {
            returns() implies (input != null)
        }
        require((input != null) && input.trim().isNotEmpty()) {"입력값이 null이거나 빈 공백 문자입니다."}
    }

    /**
     * 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
     */
    private fun validateOperator(operator: String) {
        require(operator.matches(AVAILABLE_OPERATOR)) {"주어진 문자열은 사칙연산 기호가 아닙니다."}
    }

    /**
     * 주어진 숫자와 연산자로 사칙연산을 수행
     */
    private fun operate(num1: Double, num2: Double, operator: String): Double {
        return when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> throw IllegalArgumentException("잘못된 연산자입니다.")
        }
    }

    companion object {
        private val AVAILABLE_OPERATOR: Regex by lazy { Regex("[+\\-*/]") }
    }
}