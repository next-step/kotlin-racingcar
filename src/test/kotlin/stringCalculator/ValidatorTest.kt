package stringCalculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class ValidatorTest {

    val validator = Validator()

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun `1 + 2 + 3`() {
        val example = validator.isValidInput("1 + 2 + 3")
        Assertions.assertThat(example).isEqualTo(true)
    }

    @Test
    fun `blank test`() {
        assertThatThrownBy { validator.isValidInput(" ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INPUT_NULL_OR_BLANK)
    }

    @Test
    fun `NULL test`() {
        assertThatThrownBy { validator.isValidInput(null) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INPUT_NULL_OR_BLANK)
    }

    @Test
    fun `1 = 2`() {
        assertThatThrownBy { validator.isValidInput("1 = 2") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INVALID_OPERATOR)
    }

    @Test
    fun `숫자로 시작하지 않는 경우 에러 처리`() {
        assertThatThrownBy { validator.isValidInput("+ 2 * 3") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INPUT_NOT_START_WITH_NUMBER)
    }

    @Test
    fun `숫자로 끝나지 않는 경우 에러 처리`() {
        assertThatThrownBy { validator.isValidInput("1 + 2 *") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INPUT_NOT_END_WITH_NUMBER)
    }

    @Test
    fun `문자가 들어가 있는 경우 에러 처리`() {
        assertThatThrownBy { validator.isValidInput("1 + 2 *") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INPUT_CONTAINS_CHARACTER)
    }
}
