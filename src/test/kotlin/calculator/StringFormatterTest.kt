package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringFormatterTest {

    @ParameterizedTest
    @CsvSource(value = ["1 2,12", "' ',''"])
    fun `공백 제거 성공`(input: String, expect: String) {
        // given
        val formatter = StringFormatter()

        // when
        val result = formatter.eraseWhiteSpace(input)

        // then
        Assertions.assertThat(result).isEqualTo(expect)
    }
}
