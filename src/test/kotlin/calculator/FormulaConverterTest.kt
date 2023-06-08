package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FormulaConverterTest {
    private val sut = FormulaConverter()

    @Test
    fun `문자열 식을 변환할 수 있다`() {
        // given
        val formula = "1 + 2"

        // when
        val result = sut.convert(formula)

        // then
        assertThat(result.startValue).isEqualTo(1.0)
        assertThat(result.nextFormulaElement()).isEqualTo(2.0.withOperation(Operation.PLUS))
        assertThat(result.nextFormulaElement()).isNull()
    }

    private fun Double.withOperation(op: Operation): FormulaElement = FormulaElement(this, op)
}
