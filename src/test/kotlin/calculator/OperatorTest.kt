package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OperatorTest {
    private val NUMBER_REGEX = Regex("\\d+")
    private val OPERATOR_REGEX = Regex("[+*-/]")

    @Test
    fun `extract number and operator`() {
        val str = "2 + 3 * 4 / 2".split(" ")
        val numberList = str.filter {
            it.matches(NUMBER_REGEX)
        }

        val operatorList = str.filter {
            it.matches(OPERATOR_REGEX)
        }

        assertThat(numberList).isEqualTo(listOf("2", "3", "4", "2"))
        assertThat(operatorList).isEqualTo(listOf("+", "*", "/"))
    }

    @Test
    fun `add operator`() {
        val result = Operator.ADD.calculation(2, 3)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `minus operator`() {
        val result = Operator.MINUS.calculation(5, 3)
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `times operator`() {
        val result = Operator.TIMES.calculation(5, 3)
        assertThat(result).isEqualTo(15)
    }

    @Test
    fun `divide operator`() {
        val result = Operator.DIVIDE.calculation(10, 2)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `select operator test`() {
        val result = Operator.selectOperator("+")
        assertThat(result).isEqualTo(Operator.ADD)
    }

    @Test
    fun `when divide zero then throw ArithmeticException`() {
        assertThatThrownBy { Operator.DIVIDE.calculation(10, 0) }
            .isInstanceOf(ArithmeticException::class.java)
            .hasMessage("0으로 나눌 수 없습니다.")
    }
}
