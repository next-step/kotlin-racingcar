package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class StringCalculatorTest {
    @Test
    fun `2 + 3 * 4 divide by 2 의 결과는`() {
        assertThat(StringCalculator().calculate("2 + 3 * 4 / 2")).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `널, 블랭크일 경우 IllegalArgumentException이 발생한다`(input: String) {
        assertThatThrownBy { StringCalculator().calculate(input) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatIllegalArgumentException().isThrownBy { StringCalculator().calculate(input) }
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy { StringCalculator().calculate(input) }
    }
}
