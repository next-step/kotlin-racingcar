package calculator

import calculator.enums.OperatorSign
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.math.sign

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `입력 값이 null 이거나 빈 공백일 경우`(input: String) {
        assertThatThrownBy {
            if (input.isNullOrBlank())
                throw IllegalArgumentException("입력값이 null 이거나 공백 입니다.")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 null 이거나 공백 입니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["@"])
    fun `사칙연산 기호가 아닌 것 체크`(input: String) {
        assertThatThrownBy {
            if (!input.equals("+") || !input.equals("-") || !input.equals("*") || !input.equals("/"))
                throw IllegalArgumentException("@는 사칙연산 기호가 아닙니다.")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("@는 사칙연산 기호가 아닙니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 / 5"])
    fun `문자열 정수와 사칙연산 기호로 분리`(input: String) {
        val splitData = input.split(" ")
        val numberList: MutableList<Int> = mutableListOf()
        val signList: MutableList<String> = mutableListOf()

        splitData.forEach {
            try {
                numberList.add(it.toInt())
            } catch (e: Exception) {
                signList.add(it)
            }
        }

        assertThat(numberList).containsExactly(2, 3, 5)
        assertThat(signList).containsExactly("+", "/")
    }

    @Test
    fun `사칙연산 계산하기`() {
        val numberList: MutableList<Int> = mutableListOf(2, 3, 5, 4, 8)
        val signList: MutableList<String> = mutableListOf("+", "/", "*", "+")
        var result = 0

        for (i in 0 until numberList.size) {
            if (i == 0) {
                result = numberList.get(i)
                continue
            }
            result = checkSignAndCalculate(signList.get(i - 1), result, numberList.get(i))
        }

        assertThat(result).isEqualTo(12)
    }

    private fun checkSignAndCalculate(sign: String, number1: Int, number2: Int): Int {
        val operatorSign = OperatorSign.values().find { it.code == sign }!!
        return operatorSign.calculate(number1, number2)
    }
}
