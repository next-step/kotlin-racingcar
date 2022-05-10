import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculationTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `Null or Empty test`(expr: String?) {
        assertThatThrownBy { Calculation(expr).run() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 2 ^ 2 / 2 - 1"])
    fun `사칙연산 아닌 문자열 test`(expr: String) {
        assertThatThrownBy { Calculation(expr).run() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 2 + 2 ^ 2 / 2 - 1"])
    fun `연속으로 숫자가 나올때`(expr: String) {
        assertThatThrownBy { Calculation(expr).run() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + + 2 ^ 2 / 2 - 1"])
    fun `연속으로 사칙연산이 나올때`(expr: String) {
        assertThatThrownBy { Calculation(expr).run() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
    @ParameterizedTest
    @ValueSource(strings = ["2 + + 2 ^ 2 / 2 -"])
    fun `마지막이 사칙연산으로 나올때`(expr: String) {
        assertThatThrownBy { Calculation(expr).run() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 2 * 2 / 2 - 1"])
    fun `white case test`(expr: String) {
        assertThat(Calculation(expr).run()).isEqualTo(3)
    }
}
