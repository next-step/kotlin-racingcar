package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {
    @ParameterizedTest
    @MethodSource("defaultArgument")
    fun `덧셈 계산 테스트`(firstNumber: Int, secondNumber: Int) {
        val result = PlusCalculator().calculate(firstNumber, secondNumber)

        val expected = firstNumber + secondNumber
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("defaultArgument")
    fun `뺄셈 계산 테스트`(firstNumber: Int, secondNumber: Int) {
        val result = MinusCalculator().calculate(firstNumber, secondNumber)

        val expected = firstNumber - secondNumber
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("defaultArgument")
    fun `곱셈 계산 테스트`(firstNumber: Int, secondNumber: Int) {
        val result = MultipleCalculator().calculate(firstNumber, secondNumber)

        val expected = firstNumber * secondNumber
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("defaultArgument")
    fun `나눗셈 계산 테스트`(firstNumber: Int, secondNumber: Int) {
        val result = DivisionCalculator().calculate(firstNumber, secondNumber)

        val expected = firstNumber / secondNumber
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("invalidDivisionArgument")
    fun `나눗셈 계산 인자 오류 테스트`(firstNumber: Int, secondNumber: Int) {
        assertThatThrownBy {
            DivisionCalculator().calculate(firstNumber, secondNumber)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    companion object {
        @JvmStatic
        private fun defaultArgument() = listOf(
            Arguments.of(2, 1),
            Arguments.of(4, 2),
            Arguments.of(6, 3),
            Arguments.of(6, 2)
        )

        @JvmStatic
        private fun invalidDivisionArgument() = listOf(
            Arguments.of(4, 3),
            Arguments.of(2, 5),
            Arguments.of(11, 2)
        )
    }
}
