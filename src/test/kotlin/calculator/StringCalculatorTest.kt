package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class StringCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `입력 값이 null이거나 빈 공백 문자일 경우 예외가 발생한다`(input: String?) {
        assertThatThrownBy {
            StringCalculator().calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `여러 연산자 값을 입력했을 때 정상 동작 한다`() {
        Assertions.assertThat(StringCalculator().calculate("2 + 3 * 4 / 2")).isEqualTo(10)
    }
}
