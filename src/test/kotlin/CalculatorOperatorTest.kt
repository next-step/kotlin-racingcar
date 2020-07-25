import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.LinkedList

class CalculatorOperatorTest {

    private val numberList = LinkedList<Int>()

    @BeforeEach
    fun setup() {
        numberList.run {
            add(99)
            add(33)
        }
    }

    @Test
    fun 더하기() {
        Assertions.assertThat(Calculator.calOperator(numList = numberList, operatorList = listOf('+'))).isEqualTo(132.0)
    }

    @Test
    fun 빼기() {
        Assertions.assertThat(Calculator.calOperator(numList = numberList, operatorList = listOf('-'))).isEqualTo(66.0)
    }

    @Test
    fun 곱하기() {
        Assertions.assertThat(Calculator.calOperator(numList = numberList, operatorList = listOf('*')))
            .isEqualTo(3267.0)
    }

    @Test
    fun 나누기() {
        Assertions.assertThat(Calculator.calOperator(numList = numberList, operatorList = listOf('/'))).isEqualTo(3.0)
    }

    @Test
    fun `0 으로 나눌 경우`() {
        Assertions.assertThatExceptionOfType(ArithmeticException::class.java).isThrownBy {
            val numList = LinkedList<Int>().apply {
                add(99)
                add(0)
            }
            Calculator.calOperator(numList = numList, operatorList = listOf('/'))
        }
    }
}
