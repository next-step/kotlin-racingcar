package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("계산기 테스트 (JUnit 5)")
class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun `문자열 계산기 테스트`(input: String) {
        val actual = execute(input)
        assertThat(actual).isEqualTo(10)
    }
}
