package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class CalculatorInputTest {

    @Test
    fun `계산식이 null이거나 Blank`() {
        val inputCalculator = InputManager()
        assertAll(
            { assertThat(inputCalculator.isContainNullOrBlank("    ")).isEqualTo(true) },
            { assertThat(inputCalculator.isContainNullOrBlank("")).isEqualTo(true) },
            { assertThat(inputCalculator.isContainNullOrBlank(null)).isEqualTo(true) }
        )
    }

    @Test
    fun `잘못된 사칙연산 기호`() {
        val inputCalculator = InputManager()
        assertThat(inputCalculator.isContainWrongOperator("4 * 3 / 3")).isEqualTo(false)
        assertThat(inputCalculator.isContainWrongOperator("4 + 3 - 3")).isEqualTo(false)
        assertThat(inputCalculator.isContainWrongOperator("4 + 3 ^ 3")).isEqualTo(true)
        assertThat(inputCalculator.isContainWrongOperator("4 & 3 - 3")).isEqualTo(true)
        assertThat(inputCalculator.isContainWrongOperator("4 + 3 h 3")).isEqualTo(true)
        assertThat(inputCalculator.isContainWrongOperator("4 + 3 ! 3")).isEqualTo(true)
    }

    @Test
    fun `Convert에서의 Exception 발생`() {
        val inputCalculator = InputManager()
        assertThatIllegalArgumentException().isThrownBy {
            inputCalculator.convertFormulaToList("")
        }
        assertThatIllegalArgumentException().isThrownBy {
            inputCalculator.convertFormulaToList("   ")
        }
        assertThatIllegalArgumentException().isThrownBy {
            inputCalculator.convertFormulaToList(null)
        }
    }

    @Test
    fun `Convert에서의 List반환`() {
        val inputCalculator = InputManager()
        assertThat(inputCalculator.convertFormulaToList("4 + 3 * 2")).isEqualTo(listOf("4", "+", "3", "*", "2"))
        assertThat(inputCalculator.convertFormulaToList("6 / 4 * 2")).isEqualTo(listOf("6", "/", "4", "*", "2"))
        assertThat(inputCalculator.convertFormulaToList("4 - 3 * 2")).isEqualTo(listOf("4", "-", "3", "*", "2"))
    }
}
