package caculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

internal class CalculatorTest {

    companion object {
        @JvmStatic
        fun source(): Stream<Arguments> {
            return Stream.of(
                arguments("2 + 3 * 4 / 2", 10),
                arguments("2 + 3 * 6 / 6", 5)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("source")
    fun `사칙 통합 연산`(input: String, expect: Double) {
        val result = Calculator().calculate(input)
        assertThat(result).isEqualTo(Number(expect))
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `입력값이 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Calculator().calculate(input) }
            .withMessage("text must be not empty")
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Calculator().calculate("1 z 1") }
            .withMessage("invalid operator token z")
    }
}
