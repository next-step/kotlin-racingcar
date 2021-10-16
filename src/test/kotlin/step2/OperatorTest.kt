package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {
    @Test
    fun `뺄셈`() {
        assertThat(OperatorType.getOperator("-").execute(5, 5)).isEqualTo(0.0)
    }

    @Test
    fun `덧셈`() {
        assertThat(OperatorType.getOperator("+").execute(5, 5)).isEqualTo(10.0)
    }

    @Test
    fun `곱셈`() {
        assertThat(OperatorType.getOperator("*").execute(5, 5)).isEqualTo(25.0)
    }

    @Test
    fun `나눗셈`() {
        assertThat(OperatorType.getOperator("/").execute(5, 5)).isEqualTo(1.0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["$", "^"])
    fun `사칙연산 기호가 아닌 경우`(wrongSymbol: String) {
        assertThatIllegalArgumentException().isThrownBy { OperatorType.getOperator(wrongSymbol) }
    }
}
