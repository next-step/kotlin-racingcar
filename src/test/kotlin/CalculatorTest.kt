
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.Calculator

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `빈 문자열이 입력된 경우 IllegalArgumentException`(source: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator(source)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 ^ 2 @ 3"])
    fun `알 수 없는 부호가 입력된 경우 IllegalArgumentException`(source: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator(source)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1a ^ 2 @ 3"])
    fun `계산 부호 외에 숫자가 아닌 항목이 입력된 경우 IllegalArgumentException`(source: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator(source)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2 + 3"])
    fun `계산 결과를 만족하는 경우`(source: String) {
        val calculator = Calculator(source)
        assertThat(calculator.result()).isEqualTo(6)
    }
}
