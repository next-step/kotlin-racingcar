package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class StringCalculatorTest {
    private val calculator = StringCalculator()

    @Test
    fun `operands가 empty인 경우`() {
        val operands = mutableListOf<Operand>()
        val operators = mutableListOf(Operator.PLUS)

        assertThrows<IllegalArgumentException> {
            calculator.calculate(operands, operators)
        }
            .also { assertThat(it.message).isEqualTo("operands, operators는 1개 이상이어야 합니다. operands: $operands operators: $operators") }
    }

    @Test
    fun `operators가 empty인 경우`() {
        val operands = mutableListOf(Operand("1.2"), Operand("3.7"))
        val operators = mutableListOf<Operator>()

        assertThrows<IllegalArgumentException> {
            calculator.calculate(operands, operators)
        }
            .also { assertThat(it.message).isEqualTo("operands, operators는 1개 이상이어야 합니다. operands: $operands operators: $operators") }
    }

    @Test
    fun `0으로 나눈 경우`() {
        assertThrows<IllegalArgumentException> {
            calculator.calculate(mutableListOf(Operand("1"), Operand("0")), mutableListOf(Operator.DIVIDE))
        }
            .also { assertThat(it.message).isEqualTo("0으로 나눌 수 없습니다") }
    }

    @ParameterizedTest
    @MethodSource("plusArguments")
    fun `더하기`(operands: MutableList<Operand>, operators: MutableList<Operator>, expectedResult: Double) {
        assertThat(calculator.calculate(operands, operators)).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("minusArguments")
    fun `빼기`(operands: MutableList<Operand>, operators: MutableList<Operator>, expectedResult: Double) {
        assertThat(calculator.calculate(operands, operators)).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("multiplyArguments")
    fun `곱하기`(operands: MutableList<Operand>, operators: MutableList<Operator>, expectedResult: Double) {
        assertThat(calculator.calculate(operands, operators)).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("divideArguments")
    fun `나누기`(operands: MutableList<Operand>, operators: MutableList<Operator>, expectedResult: Double) {
        assertThat(calculator.calculate(operands, operators)).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("complexArguments")
    fun `사칙연산`(operands: MutableList<Operand>, operators: MutableList<Operator>, expectedResult: Double) {
        assertThat(calculator.calculate(operands, operators)).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun plusArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(mutableListOf(Operand("1"), Operand("1")), mutableListOf(Operator.PLUS), 2.0),
                Arguments.arguments(mutableListOf(Operand("-2147483648"), Operand("2147483647")), mutableListOf(Operator.PLUS), -1.0),
                Arguments.arguments(mutableListOf(Operand("5.2"), Operand("2.2")), mutableListOf(Operator.PLUS), 7.4),
            )
        }

        @JvmStatic
        fun minusArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(mutableListOf(Operand("1"), Operand("1")), mutableListOf(Operator.MINUS), 0.0),
                Arguments.arguments(mutableListOf(Operand("17328.125"), Operand("17328.25")), mutableListOf(Operator.MINUS), -0.125),
                Arguments.arguments(mutableListOf(Operand("0.0"), Operand("0.0")), mutableListOf(Operator.MINUS), 0.0),
            )
        }

        @JvmStatic
        fun multiplyArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(mutableListOf(Operand("1"), Operand("1")), mutableListOf(Operator.MULTIPLY), 1.0),
                Arguments.arguments(mutableListOf(Operand("358"), Operand("359")), mutableListOf(Operator.MULTIPLY), 128522.0),
                Arguments.arguments(mutableListOf(Operand("5.58"), Operand("9.32")), mutableListOf(Operator.MULTIPLY), 52.0056),
            )
        }

        @JvmStatic
        fun divideArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(mutableListOf(Operand("1"), Operand("1")), mutableListOf(Operator.DIVIDE), 1.0),
                Arguments.arguments(mutableListOf(Operand("52.4"), Operand("0.8")), mutableListOf(Operator.DIVIDE), 65.5),
            )
        }

        @JvmStatic
        fun complexArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(mutableListOf(Operand("1"), Operand("2"), Operand("3"), Operand("4")), mutableListOf(Operator.PLUS, Operator.MULTIPLY, Operator.DIVIDE), 2.25),
                Arguments.arguments(mutableListOf(Operand("5"), Operand("7"), Operand("0"), Operand("0.8")), mutableListOf(Operator.MINUS, Operator.MULTIPLY, Operator.DIVIDE), 0.0),
            )
        }
    }
}
