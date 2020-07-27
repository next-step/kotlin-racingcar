package week1.step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.LinkedList

class CalculatorOperatorTest {

    private val numberGroup = LinkedList<Double>()

    @BeforeEach
    fun setup() {
        numberGroup.run {
            add(99.0)
            add(33.0)
        }
    }

    @Test
    fun 더하기() {
        Assertions.assertThat(
            Calculator.calOperator(
                numberGroup = numberGroup, operatorGroup = listOf(
                    Operator.PLUS
                )
            )
        )
            .isEqualTo(132.0)
    }

    @Test
    fun 빼기() {
        Assertions.assertThat(
            Calculator.calOperator(
                numberGroup = numberGroup, operatorGroup = listOf(
                    Operator.MINUS
                )
            )
        )
            .isEqualTo(66.0)
    }

    @Test
    fun 곱하기() {
        Assertions.assertThat(
            Calculator.calOperator(
                numberGroup = numberGroup,
                operatorGroup = listOf(Operator.MULTIPLE)
            )
        )
            .isEqualTo(3267.0)
    }

    @Test
    fun 나누기() {
        Assertions.assertThat(
            Calculator.calOperator(
                numberGroup = numberGroup,
                operatorGroup = listOf(Operator.DIVIDE)
            )
        )
            .isEqualTo(3.0)
    }

    @Test
    fun `0 으로 나눌 경우`() {
        Assertions.assertThatExceptionOfType(ArithmeticException::class.java).isThrownBy {
            val numberGroup = LinkedList<Double>().apply {
                add(99.0)
                add(0.0)
            }
            Calculator.calOperator(numberGroup = numberGroup, operatorGroup = listOf(Operator.DIVIDE))
        }
    }
}
