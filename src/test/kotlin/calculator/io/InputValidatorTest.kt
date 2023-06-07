package calculator.io

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    private lateinit var inputValidator: InputValidator

    @BeforeEach
    fun setUp() {
        inputValidator = InputValidator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun `올바른 값 입력`(input: String) {
        assertThat(inputValidator.validate(input)).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(strings = [" "])
    fun `공백 입력`(input: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [""])
    fun `빈 값 입력`(input: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validate(input)
        }
    }
}
