package calculator

import calculator.Operation.Addition
import calculator.Operation.Division
import calculator.Operation.Multiplication
import calculator.Operation.Subtraction
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun add() {
        val result = Addition.calculate(1, 1)
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun subtract() {
        val result = Subtraction.calculate(2, 1)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun multiply() {
        val result = Multiplication.calculate(2, 2)

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun divide() {
        val result = Division.calculate(4, 2)

        assertThat(result).isEqualTo(2)
    }
}
