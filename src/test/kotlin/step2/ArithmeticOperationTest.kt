package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ArithmeticOperationTest {
    @ParameterizedTest
    @MethodSource("plusArgument")
    fun `덧셈 계산 테스트`(firstNumber: Int, secondNumber: Int, expected: Int) {
        val result = ArithmeticOperation.PLUS.execute(firstNumber, secondNumber)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("minusArgument")
    fun `뺄셈 계산 테스트`(firstNumber: Int, secondNumber: Int, expected: Int) {
        val result = ArithmeticOperation.MINUS.execute(firstNumber, secondNumber)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("multipleArgument")
    fun `곱셈 계산 테스트`(firstNumber: Int, secondNumber: Int, expected: Int) {
        val result = ArithmeticOperation.MULTIPLE.execute(firstNumber, secondNumber)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("divisionArgument")
    fun `나눗셈 계산 테스트`(firstNumber: Int, secondNumber: Int, expected: Int) {
        val result = ArithmeticOperation.DIVISION.execute(firstNumber, secondNumber)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("invalidDivisionArgument")
    fun `나눗셈 계산 인자 오류 테스트`(firstNumber: Int, secondNumber: Int) {
        assertThatThrownBy {
            ArithmeticOperation.DIVISION.execute(firstNumber, secondNumber)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    companion object {
        @JvmStatic
        private fun plusArgument() = listOf(
            Arguments.of(2, 1, 3),
            Arguments.of(4, 2, 6),
            Arguments.of(6, 3, 9),
            Arguments.of(6, 2, 8)
        )

        @JvmStatic
        private fun minusArgument() = listOf(
            Arguments.of(2, 1, 1),
            Arguments.of(4, 2, 2),
            Arguments.of(6, 3, 3),
            Arguments.of(6, 2, 4)
        )

        @JvmStatic
        private fun multipleArgument() = listOf(
            Arguments.of(2, 1, 2),
            Arguments.of(4, 2, 8),
            Arguments.of(6, 3, 18),
            Arguments.of(6, 2, 12)
        )

        @JvmStatic
        private fun divisionArgument() = listOf(
            Arguments.of(2, 1, 2),
            Arguments.of(4, 2, 2),
            Arguments.of(6, 3, 2),
            Arguments.of(6, 2, 3)
        )

        @JvmStatic
        private fun invalidDivisionArgument() = listOf(
            Arguments.of(4, 3),
            Arguments.of(2, 5),
            Arguments.of(11, 2)
        )
    }
}
