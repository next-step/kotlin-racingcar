package racingcar

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["3.3", "0", "abc"])
    fun `자연수인지 잘 판단하는지 테스트`(input: String) {
        assertThrows<IllegalArgumentException> { InputValidator.checkNaturalNumber(input) }
    }
}
