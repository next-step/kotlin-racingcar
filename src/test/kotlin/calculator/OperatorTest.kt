package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal
import java.math.MathContext

@TestInstance(PER_CLASS)
class OperatorTest {

    @ParameterizedTest
    @CsvSource(
        "'1', '2'",
        "'5', '-7'",
        "'-150', '478'",
        "'10.123', '20.987'",
        "'-123.456', '786.983'",
        "'4567.1234', '-5837.1266'",
    )
    fun `덧셈 테스트`(operand1: String, operand2: String) {
        val firstOperand = Operand.from(operand1)
        val secondOperand = Operand.from(operand2)

        val result = Operator.findOperation("+").perform(firstOperand, secondOperand)

        assertThat(result).isEqualTo(Operand(firstOperand.value + secondOperand.value))
    }

    @ParameterizedTest
    @CsvSource(
        "'1', '2'",
        "'5', '-7'",
        "'-150', '478'",
        "'10.123', '20.987'",
        "'-123.456', '786.983'",
        "'4567.1234', '-5837.1266'",
    )
    fun `뺄셈 테스트`(operand1: String, operand2: String) {
        val firstOperand = Operand.from(operand1)
        val secondOperand = Operand.from(operand2)

        val result = Operator.findOperation("-").perform(firstOperand, secondOperand)

        assertThat(result).isEqualTo(Operand(firstOperand.value - secondOperand.value))
    }

    @ParameterizedTest
    @CsvSource(
        "'1', '2'",
        "'5', '-7'",
        "'-150', '478'",
        "'10.123', '20.987'",
        "'-123.456', '786.983'",
        "'4567.1234', '-5837.1266'",
    )
    fun `곱셈 테스트`(operand1: String, operand2: String) {
        val firstOperand = Operand.from(operand1)
        val secondOperand = Operand.from(operand2)

        val result = Operator.findOperation("*").perform(Operand.from(operand1), Operand.from(operand2))

        assertThat(result).isEqualTo(Operand(firstOperand.value * secondOperand.value))
    }

    @ParameterizedTest
    @CsvSource(
        "'1', '2'",
        "'5', '-7'",
        "'-150', '478'",
        "'10.123', '20.987'",
        "'-123.456', '786.983'",
        "'4567.1234', '-5837.1266'",
    )
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
    }

    @ParameterizedTest
    @ValueSource(strings = ["123", "abc", "!", "?"])
    fun `잘못된 연산기호 테스트`(operatorSymbol: String) {
        assertThatThrownBy {
            Operator.findOperation(operatorSymbol)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
