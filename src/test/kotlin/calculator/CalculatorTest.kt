package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {

    lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3"])
    fun `덧셈`(operation: String) {
        val expression = Expression(operation)
        val (numbers, operators) = expression.partitionExpression()
        assertThat(calculator.calculate(numbers, operators)).isEqualTo(5.0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 - 3"])
    fun `뺄셈`(operation: String) {
        val expression = Expression(operation)
        val (numbers, operators) = expression.partitionExpression()
        assertThat(calculator.calculate(numbers, operators)).isEqualTo(-1.0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["5 * 9"])
    fun `곱셈`(operation: String) {
        val expression = Expression(operation)
        val (numbers, operators) = expression.partitionExpression()
        assertThat(calculator.calculate(numbers, operators)).isEqualTo(45.0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["13 / 2"])
    fun `나눗셈`(operation: String) {
        val expression = Expression(operation)
        val (numbers, operators) = expression.partitionExpression()
        assertThat(calculator.calculate(numbers, operators)).isEqualTo(6.5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["13 / 0"])
    fun `0 나눗셈`(operation: String) {
        val expression = Expression(operation)
        val (numbers, operators) = expression.partitionExpression()
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            calculator.calculate(numbers, operators)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun `사칙연산을 모두 포함하는 연산`(operation: String) {
        val expression = Expression(operation)
        val (numbers, operators) = expression.partitionExpression()
        assertThat(calculator.calculate(numbers, operators)).isEqualTo(10.0)
    }
}
