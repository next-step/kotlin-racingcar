package step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ParamValidatorTest {
    @Test
    fun `validateNotNull`() {
        ParamValidator.validateNotNull("1 + 2")

        ParamValidator.validateNotNull("")

        ParamValidator.validateNotNull(" ")

        Assertions.assertThatThrownBy { ParamValidator.validateNotNull(null) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 null 입니다.")
    }

    @Test
    fun `validateNonEmpty`() {
        ParamValidator.validateNonEmpty("1 + 2")
        Assertions.assertThatThrownBy { ParamValidator.validateNonEmpty("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 비어 있거나 공백 문자입니다.")

        Assertions.assertThatThrownBy { ParamValidator.validateNonEmpty("  ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 비어 있거나 공백 문자입니다.")
    }
}