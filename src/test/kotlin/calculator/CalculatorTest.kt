package calculator

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CalculatorTest {

    @Test
    fun `null을 전달하면 예외가 발생한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Calculator().execute(null) }
    }

    @Test
    fun `빈 값을 전달하면 예외가 발생한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Calculator().execute("") }

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Calculator().execute(" ") }

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Calculator().execute("      ") }
    }

    @ParameterizedTest
    @MethodSource("testCalculateData")
    fun `계산기를 테스트한다`(formula: String, result: Double) {
        assertEquals(result, Calculator().execute(formula))
    }

    companion object {
        @JvmStatic
        fun testCalculateData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of("3 + 5 - 2 * 4 / 2", "12"),
                Arguments.of("13 - 5 * 2 + 4 / 4", "5"),
                Arguments.of("2 * 4.0 / 2 + 4 - 1", "7")
            )
        }
    }
}
