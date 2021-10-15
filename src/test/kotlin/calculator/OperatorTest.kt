package calculator

import calculator.Operator.Companion.CANNOT_BE_DIVIDED_BY_ZERO
import calculator.Operator.Companion.WRONG_OPERATOR_SYMBOL
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal
import java.math.MathContext
import java.util.stream.Stream

@TestInstance(PER_CLASS)
class OperatorTest {

    private fun operandStringArrayProvider(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("1", "2"),
            Arguments.of("5", "-7"),
            Arguments.of("-150", "478"),
            Arguments.of("10.123", "20.987"),
            Arguments.of("-123.456", "786.983"),
            Arguments.of("4567.1234", "-5837.1266"),
        )
    }

    private fun wrongOperatorSymbolProvider(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("123"),
            Arguments.of("abc"),
            Arguments.of("!"),
            Arguments.of("?")
        )
    }

    @ParameterizedTest
    @MethodSource("operandStringArrayProvider")
    fun `덧셈 테스트`(operand1: String, operand2: String) {
        val firstOperand = Operand.from(operand1)
        val secondOperand = Operand.from(operand2)

        val result = Operator.findOperation("+").perform(firstOperand, secondOperand)

        assertThat(result).isEqualTo(Operand(firstOperand.value + secondOperand.value))
    }

    @ParameterizedTest
    @MethodSource("operandStringArrayProvider")
    fun `뺄셈 테스트`(operand1: String, operand2: String) {
        val firstOperand = Operand.from(operand1)
        val secondOperand = Operand.from(operand2)

        val result = Operator.findOperation("-").perform(firstOperand, secondOperand)

        assertThat(result).isEqualTo(Operand(firstOperand.value - secondOperand.value))
    }

    @ParameterizedTest
    @MethodSource("operandStringArrayProvider")
    fun `곱셈 테스트`(operand1: String, operand2: String) {
        val firstOperand = Operand.from(operand1)
        val secondOperand = Operand.from(operand2)

        val result = Operator.findOperation("*").perform(Operand.from(operand1), Operand.from(operand2))

        assertThat(result).isEqualTo(Operand(firstOperand.value * secondOperand.value))
    }

    @ParameterizedTest
    @MethodSource("operandStringArrayProvider")
    fun `나눗셈 테스트`(operand1: String, operand2: String) {
        val firstOperand = Operand.from(operand1)
        val secondOperand = Operand.from(operand2)

        val result = Operator.findOperation("/").perform(firstOperand, secondOperand)

        assertThat(result).isEqualTo(Operand(firstOperand.value.divide(secondOperand.value, MathContext.DECIMAL32)))
    }

    @Test
    fun `제수가 0인 나눗셈 테스트`() {
        val firstOperand = Operand(BigDecimal.TEN)
        val secondOperand = Operand(BigDecimal.ZERO)

        assertThatThrownBy {
            Operator.findOperation("/").perform(firstOperand, secondOperand)
        }
        .isInstanceOf(IllegalArgumentException::class.java)
        .hasMessageContaining(CANNOT_BE_DIVIDED_BY_ZERO)
    }

    @ParameterizedTest
    @MethodSource("wrongOperatorSymbolProvider")
    fun `잘못된 연산기호 테스트`(operatorSymbol: String) {
        assertThatThrownBy {
            Operator.findOperation(operatorSymbol)
        }
        .isInstanceOf(IllegalArgumentException::class.java)
        .hasMessageContaining(WRONG_OPERATOR_SYMBOL)
    }


}
