package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputValidatorTest {
    @ParameterizedTest
    @CsvSource(value = ["3,true", "0,false", "3.3,false", "1,true", "-3,false"])
    fun `자연수인지 잘 판단하는지 테스트`(input: String, expect: Boolean) {
        val result = InputValidator.isNaturalNumber(input)
        Assertions.assertThat(result).isEqualTo(expect)
    }
}
