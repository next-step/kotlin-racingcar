package study.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class ExpressionTest {

    @ParameterizedTest
    @MethodSource("expressionNumbersProvider")
    fun `입력받은 수식에서 숫자들을 순차적으로 추출한다`(
        mathExpression: String,
        expected: List<Double>
    ) {
        // When
        val actual = Expression(mathExpression).getNumbersFromExpression()

        // Then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(value = ["!+2", "2+!", "@4+%3", "666+4$%#%#3"])
    fun `입력값중에 사칙연산자를 제외한 특수문자가 있을 경우 에러를 반환한다`(
        mathExpression: String,
    ) {
        assertThrows<NumberFormatException> {
            Expression(mathExpression).getNumbersFromExpression()
        }
    }

    @ParameterizedTest
    @MethodSource("expressionSpecialCharactersProvider")
    fun `입력받은 수식에서 숫자가 아닌문자들을 순차적으로 추출한다`(
        mathExpression: String,
        expected: List<String>
    ) {
        // When
        val actual = Expression(mathExpression).getSpecialCharactersFromExpression()

        // Then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(value = ["1234", "+1"])
    fun `입력받은 수식에 숫자나 연산자가 누락된 경우 에러를 반환한다`(
        mathExpression: String
    ) {
        assertThrows<IllegalArgumentException> {
            Expression(mathExpression).processExpression()
        }
    }

    @ParameterizedTest
    @MethodSource("calculationExpressionProvider")
    fun `입력받은 수식을 순차적으로 연산하여 결과를 반환한다`(
        mathExpression: String,
        expected: Double
    ) {
        // When
        val actual = Expression(mathExpression).processExpression()

        // Then
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun expressionNumbersProvider() = listOf(
            Arguments.of("3*2+1-1/1", listOf(3.0, 2.0, 1.0, 1.0, 1.0)),
            Arguments.of("10-1/1*2", listOf(10.0, 1.0, 1.0, 2.0)),
            Arguments.of("5*2/2-1-2", listOf(5.0, 2.0, 2.0, 1.0, 2.0)),
            Arguments.of("20+2/10*5", listOf(20.0, 2.0, 10.0, 5.0)),
        )

        @JvmStatic
        fun expressionSpecialCharactersProvider() = listOf(
            Arguments.of("3*2+1-1/1", listOf("*", "+", "-", "/")),
            Arguments.of("10-1/1*2", listOf("-", "/", "*")),
            Arguments.of("5*2/2-1-2", listOf("*", "/", "-", "-")),
            Arguments.of("20+2/10*5", listOf("+", "/", "*")),
        )

        @JvmStatic
        fun calculationExpressionProvider() = listOf(
            Arguments.of("1+2", 3.0),
            Arguments.of("3*2+1-1/1", 6.0),
            Arguments.of("10-1/1*2", 18.0),
            Arguments.of("5*2/2-1-2", 2.0),
            Arguments.of("20+2/10*5", 11.0),
        )
    }
}
