package calculator.unit

import calculator.Formula
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class FormulaTest {

    @Test
    fun `수식을 입력받고 계산한다`() {
        val inputFormula = Formula("1 + 2 * 3 - 4 / 5")
        assertThat(inputFormula.calculateFormula()).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 a 5", "1 2 3"])
    fun `수식의 연산자 자리에 연산자가 들어가지 않으면 오류를 반환한다`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            Formula(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [" 1 + 4", "1 + 4 ", "1 +  4", "1 + 4 5", "1 + 4 5 6", "1 + 4 /"])
    fun `수식의 형식이 올바르지 않으면 오류를 반환한다`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            Formula(input)
        }
    }
}
