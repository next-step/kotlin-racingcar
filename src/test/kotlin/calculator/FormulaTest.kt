package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class FormulaTest {

    @Test
    fun `수식을 입력받고 계산한다`() {
        val inputFormula = Formula("1 + 2 * 3 - 4 / 5")
        assertThat(inputFormula.calculateFormula()).isEqualTo(1)
    }





}
