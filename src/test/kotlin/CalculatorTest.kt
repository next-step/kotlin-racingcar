
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import study.Calculator

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `빈 문자열이 입력된 경우 IllegalArgumentException`(source: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            val calculator = Calculator()
            calculator.append(source)
            calculator.result()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 ^ 2 @ 3"])
    fun `알 수 없는 부호가 입력된 경우 IllegalArgumentException`(source: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            val calculator = Calculator()
            calculator.append(source)
            calculator.result()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1a ^ 2 @ 3"])
    fun `계산 부호 외에 숫자가 아닌 항목이 입력된 경우 IllegalArgumentException`(source: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            val calculator = Calculator()
            calculator.append(source)
            calculator.result()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2 + 3"])
    fun `계산 결과를 만족하는 경우`(source: String) {
        val calculator = Calculator()
        calculator.append(source)
        assertThat(calculator.result()).isEqualTo(6)
    }

    @ParameterizedTest
    @CsvSource(
        "1 + 2, + 2 + 3"
    )
    fun `계산 결과를 연속적으로 입력하는 경우 합산된 값이 나와야 함`(source1: String, source2: String) {
        val calculator = Calculator()
        calculator.append(source1)
        calculator.append(source2)
        assertThat(calculator.result()).isEqualTo(8)
    }

    @ParameterizedTest
    @CsvSource(
        "1 + 2, 1 + 2 + 3"
    )
    fun `계산 중 clear 시, 결과값 초기셋팅이 되어야 함`(source1: String, source2: String) {
        val calculator = Calculator()
        calculator.append(source1)
        calculator.clear()

        calculator.append(source2)
        assertThat(calculator.result()).isEqualTo(6)
    }
}
