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

    @ParameterizedTest
    @ValueSource(strings = ["abc,asdfas", "asdfasd,abc", "ffffabc"])
    fun `자동차 이름 제한을 잘 판단하는지 테스트`(input: String) {
        val split = input.split(",")
        assertThrows<IllegalArgumentException> { InputValidator.checkNameLength(split) }
    }
}
