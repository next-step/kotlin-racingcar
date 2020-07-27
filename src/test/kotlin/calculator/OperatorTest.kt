package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {
    private val numberRegex = Regex("\\d+")
    private val operatorRegex = Regex("[+*-/]")

    @Test
    fun `extract number and operator`() {
        val str = "2 + 3 * 4 / 2".split(" ")
        val numberList = str.filter {
            it.matches(numberRegex)
        }

        val operatorList = str.filter {
            it.matches(operatorRegex)
        }

        assertThat(numberList).isEqualTo(listOf("2", "3", "4", "2"))
        assertThat(operatorList).isEqualTo(listOf("+", "*", "/"))
    }

    @Test
    fun `add operator`() {
        val result = Operator.ADD.apply(2, 3)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `minus operator`() {
        val result = Operator.MINUS.apply(5, 3)
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `times operator`() {
        val result = Operator.TIMES.apply(5, 3)
        assertThat(result).isEqualTo(15)
    }

    @Test
    fun `divide operator`() {
        val result = Operator.DIVIDE.apply(10, 2)
        assertThat(result).isEqualTo(5)
    }
}
