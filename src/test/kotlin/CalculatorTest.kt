import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "2 + 3 = 5",
        "7 - 6 = 1",
        "5 * 3 = 15",
        "20 / 4 = 5",
        "6 + 3 - 5 * 3 / 6 = 2",
        delimiter = '='
    )
    fun `계산기 정상 작동`(expression: String, result: Int) {
        // given
        val calculator = Calculator()
        // when, then
        assertThat(calculator.calculate(expression)).isEqualTo(result)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값이 null 이거나 빈 공백 문자 일 경우 IAE`(list: String?) {
        // given
        val calculator = Calculator()
        // when
        val exception = assertThrows<IllegalArgumentException> { calculator.calculate(list)}
        // then
        assert(exception.message == "계산식이 NULL 혹은 공백입니다.")
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IAE`() {
        // given
        val calculator = Calculator()
        // when
        val exception = assertThrows<IllegalArgumentException> { calculator.calculate("7 ! 3") }
        // then
        assertThat(exception.message).isEqualTo("사칙연산 기호가 아닙니다.")
    }

    @Test
    fun `분모가 0인 경우 AE 발생`() {
        // given
        val calculator = Calculator()
        // when
        val exception = assertThrows<ArithmeticException> { calculator.calculate("5 / 0") }
        // then
        assertThat(exception.message).isEqualTo("분모는 0이 될 수 없습니다.")
    }
}
