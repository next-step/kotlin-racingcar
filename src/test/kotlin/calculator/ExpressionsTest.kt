package calculator

import calculator.ExpressionParser.parse
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.Collections
import java.util.stream.Stream

internal class ExpressionsTest {
    private fun parseOperand(input: Iterable<String>): List<Operand> =
        input.parse(Operand.isOrderOf, Operand.CONVERT_TO_OPERAND)

    private fun parseOperator(input: Iterable<String>): List<Operator> =
        input.parse(Operator.isOrderOf, Operator.convertToOperator)

    companion object {
        @JvmStatic
        fun expressionsProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf("10"),
                    listOf(Operand("10")),
                    Collections.EMPTY_LIST
                ),
                Arguments.of(
                    listOf("1", "+", "2"),
                    listOf(Operand("1"), Operand("2")),
                    listOf(Operator.PLUS)
                ),
                Arguments.of(
                    listOf("8", "/", "5", "-", "50"),
                    listOf(Operand("8"), Operand("5"), Operand("50")),
                    listOf(Operator.DIVIDED, Operator.MINUS)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("expressionsProvider")
    fun `입력값에서 숫자를 파싱한다`(input: List<String>, operands: List<Operand>) {
        assertThat(parseOperand(input)).isEqualTo(operands)
    }

    @ParameterizedTest
    @MethodSource("expressionsProvider")
    fun `입력값에서 연산자를 파싱한다`(input: List<String>, operands: List<Operand>, operators: List<Operator>) {
        assertThat(parseOperator(input)).isEqualTo(operators)
    }

    @Test
    fun `숫자 자리에 문자가 들어가면 예외 발생`() {
        val input = listOf("-", "+", "j")
        Assertions.assertThatThrownBy {
            parseOperand(input)
        }.isInstanceOf(NumberFormatException::class.java)
    }

    @Test
    fun `문자 자리에 숫자가 들어가면 예외 발생`() {
        val input = listOf("1", "1", "5")
        Assertions.assertThatThrownBy {
            parseOperator(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `연산자 숫자가 피연산자보다 하나 적은 경우를 제외하고 예외 발생`() {
        val input = listOf("50", "%", "20", "+")
        Assertions.assertThatThrownBy {
            parseOperator(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
