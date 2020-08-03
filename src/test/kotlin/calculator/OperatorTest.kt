package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["+"])
    fun `Symbol addiction test`(operator: String) {
        assertThat(Operator.ADD.symbol).isEqualTo("+")
    }

    @ParameterizedTest
    @ValueSource(strings = ["-"])
    fun `Symbol subtraction test`(operator: String) {
        assertThat(Operator.SUB.symbol).isEqualTo("-")
    }

    @ParameterizedTest
    @ValueSource(strings = ["*"])
    fun `Symbol multiply test`(operator: String) {
        assertThat(Operator.MUL.symbol).isEqualTo("*")
    }

    @ParameterizedTest
    @ValueSource(strings = ["/"])
    fun `Symbol divide test`(operator: String) {
        assertThat(Operator.DIV.symbol).isEqualTo(operator)
    }

    @Test
    fun `Addiction test`() {
        assertThat(Operator.ADD.invoke(3, 36)).isEqualTo(39)
    }

    @ParameterizedTest
    @CsvSource("10, 3, 7", "3, 3, 0", "3, -10, 13", "3, 10, -7")
    fun `Subtraction test`(target: Int, input: Int, result: Int) {
        assertThat(Operator.SUB.invoke(target, input)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("10, 3, 30,", "1, 2, 2")
    fun `Multiply test`(target: Int, input: Int, result: Int) {
        assertThat(Operator.MUL.invoke(target, input)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("10, 0", "0, 0")
    fun `Divide test`(target: Int, input: Int) {
        assertThatThrownBy { Operator.DIV.invoke(target, input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Can't be divided by zero.")
    }
}
