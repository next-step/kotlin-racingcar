package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculationTest {
    @ParameterizedTest
    @ValueSource(strings = [" ", ""])
    fun `empty or blank가 들어오면 실패한다`(expr: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { Calculation(expr).run() }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 2 ^ 2 / 2 - 1"])
    fun `사칙연산 아닌 문자열이 포함되어 있으면 실패한다`(expr: String) {
        assertThrows<NoSuchElementException> {
            Calculation(expr).run()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 2 + 2 ^ 2 / 2 - 1"])
    fun `숫자가 연속으로 입력되어 있으면 실패한다`(expr: String) {
        assertThrows<NoSuchElementException> {
            Calculation(expr).run()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + + 2 ^ 2 / 2 - 1"])
    fun `사칙연산이 연속으로 입력되면 실패한다`(expr: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { Calculation(expr).run() }
    }

    @ParameterizedTest
    @ValueSource(strings = ["+ 2 - 1"])
    fun `처음 입력이 숫자가 아니면 실패한다`(expr: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { Calculation(expr).run() }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 / 0"])
    fun `0으로 나누는 연산은 실패한다`(expr: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { Calculation(expr).run() }
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2 - 1 * 10 - 1, 9",
            "5 / 7 - 2, -2",
            "2 + 3 * 2 - 2 - 5, 3",
        ]
    )
    fun `정상 수식은 성공한다`(expr: String, answer: Int) {
        assertThat(Calculation(expr).run())
            .isEqualTo(answer)
            .isInstanceOf(Integer::class.java)
    }
}
