package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class EquationValidatorTest {
    private val equationValidator = EquationValidator()

    @Test
    fun validate() {
        assertThrows<IllegalArgumentException> { equationValidator.validateEquation("") }
            .also { assertThat(it.message).isEqualTo("빈 값은 입력할 수 없습니다.") }
    }
}
