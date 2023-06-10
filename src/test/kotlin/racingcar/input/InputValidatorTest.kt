package racingcar.input

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputValidatorTest {
    private lateinit var inputValidator: InputValidator

    @BeforeEach
    fun setUp() {
        inputValidator = InputValidator()
    }

    @ParameterizedTest
    @CsvSource(value = ["qwe,False", "12q,False", "123,True"])
    fun `입력 값이 숫자인지 파악 테스트`(input: String, expect: Boolean) {
        assertThat(inputValidator.isNumber(input)).isEqualTo(expect)
    }
}
