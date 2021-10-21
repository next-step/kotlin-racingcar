package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {
    @Test
    fun `뺄셈`() {
        assertThat(OperatorType.findOperator("-").invoke(Operand(5.0), Operand(5.0))).isEqualTo(Operand(0.0))
    }

    @Test
    fun `덧셈`() {
        assertThat(OperatorType.findOperator("+").invoke(Operand(5.0), Operand(5.0))).isEqualTo(Operand(10.0))
    }

    @Test
    fun `곱셈`() {
        assertThat(OperatorType.findOperator("*").invoke(Operand(5.0), Operand(5.0))).isEqualTo(Operand(25.0))
    }

    @Test
    fun `나눗셈`() {
        assertThat(OperatorType.findOperator("/").invoke(Operand(5.0), Operand(5.0))).isEqualTo(Operand(1.0))
    }

    @ParameterizedTest
    @ValueSource(strings = ["$", "^"])
    fun `사칙연산 기호가 아닌 경우`(wrongSymbol: String) {
        assertThatIllegalArgumentException().isThrownBy { OperatorType.findOperator(wrongSymbol) }
    }
}
