package calculator

import calculator.ExpressionParser.Companion.parse
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.NumberFormatException
import java.util.Collections
import java.util.stream.Stream

internal class ExpressionParserTest {
    companion object {
        private fun parseNumber(input: Iterable<String>): List<Number> = input.parse(Number.isOrderOf, Number.convertToNumber)
        private fun parseOperator(input: Iterable<String>): List<Operator> = input.parse(Operator.isOrderOf, Operator.convertToOperator)
        @JvmStatic
        fun sumProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf("10"),
                    listOf(Number("10")),
                    Collections.EMPTY_LIST
                ),
                Arguments.of(
                    listOf("1", "+", "2"),
                    listOf(Number("1"), Number("2")),
                    listOf(Operator.PLUS)
                ),
                Arguments.of(
                    listOf("8", "/", "5", "-", "50"),
                    listOf(Number("8"), Number("5"), Number("50")),
                    listOf(Operator.DIVIDED, Operator.MINUS)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("sumProvider")
    fun `입력값에서 숫자를 파싱한다`(input: List<String>, numbers: List<Number>) {
        assertThat(parseNumber(input)).isEqualTo(numbers)
    }

    @ParameterizedTest
    @MethodSource("sumProvider")
    fun `입력값에서 연산자를 파싱한다`(input: List<String>, numbers: List<Number>, operators: List<Operator>) {
        assertThat(parseOperator(input)).isEqualTo(operators)
    }

    @Test
    fun `숫자 자리에 문자가 들어가면 예외 발생`() {
        val input = listOf("-", "+", "j")
        Assertions.assertThatThrownBy {
            parseNumber(input)
        }.isInstanceOf(NumberFormatException::class.java)
    }

    @Test
    fun `문자 자리에 숫자가 들어가면 예외 발생`() {
        val input = listOf("1", "1", "5")
        Assertions.assertThatThrownBy {
            parseOperator(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
