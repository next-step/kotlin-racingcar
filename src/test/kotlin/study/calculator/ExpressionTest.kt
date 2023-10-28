package study.calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class ExpressionTest {

    companion object {
        @JvmStatic
        fun provideExpressionEvaluateSources() = listOf(
            Arguments.of(10, Expression("+", "30"), 40),
            Arguments.of(60, Expression("-", "20"), 40),
            Arguments.of(4, Expression("*", "10"), 40),
            Arguments.of(80, Expression("/", "2"), 40),
        )
    }

    @ParameterizedTest
    @CsvSource(
        "3,3",
        "-,-",
        "o,24",
        "$,100"
    )
    fun `부적절한 객체 생성`(operatorToken: String, numberToken: String) {
        assertThrows<IllegalArgumentException> {
            Expression(operatorToken, numberToken)
        }
    }

    @ParameterizedTest
    @MethodSource("provideExpressionEvaluateSources")
    fun `Expression 계산`(operand: Int, expression: Expression, result: Int) {
        assertEquals(result, expression.operator.evaluate(operand, expression.number))
    }
}
