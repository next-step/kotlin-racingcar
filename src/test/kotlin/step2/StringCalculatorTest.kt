package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class StringCalculatorTest {
    @Test
    fun `계산식의 결과가 정상적으로 반환된다`() {
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `널, 블랭크일 경우 IllegalArgumentException이 발생한다`(input: String) {
        assertAll(
            { assertThatThrownBy { StringCalculator.calculate(input) }.isInstanceOf(IllegalArgumentException::class.java) },
            { assertThatIllegalArgumentException().isThrownBy { StringCalculator.calculate(input) } },
            { assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy { StringCalculator.calculate(input) } }
        )
    }
}
