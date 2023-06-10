package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    private val stringCalculator = StringCalculator()

    @Test
    fun `기본 예제 테스트`() {
        val expression = "2 + 3 * 4 / 2"
        val result = stringCalculator.calculate(expression)

        assertThat(result).isEqualTo(10F)
    }

    @Test
    fun `기본 덧셈 테스트`() {
        val result = stringCalculator.add(1F, 12F)

        assertThat(result).isEqualTo(13F)
    }

    @Test
    fun `기본 뺄셈 테스트`() {
        val result1 = stringCalculator.subtract(1F, 12F)
        val result2 = stringCalculator.subtract(12F, 1F)

        assertThat(result1).isEqualTo(-11F)
        assertThat(result2).isEqualTo(11F)
    }

    @Test
    fun `기본 곱셈 테스트`() {
        val result1 = stringCalculator.multiply(1F, 12F)
        val result2 = stringCalculator.multiply(1F, 0F)
        val result3 = stringCalculator.multiply(3F, 0.5F)

        assertThat(result1).isEqualTo(12F)
        assertThat(result2).isEqualTo(0F)
        assertThat(result3).isEqualTo(1.5F)
    }

    @Test
    fun `기본 나눗셈 테스트`() {
        val result1 = stringCalculator.divide(10F, 5F)
        val result2 = stringCalculator.divide(3F, 2F)

        assertThat(result1).isEqualTo(2F)
        assertThat(result2).isEqualTo(1.5F)
    }

    @Test
    fun `0으로 나누면 에러가 발생한다`() {
        assertThatIllegalArgumentException()
            .isThrownBy { stringCalculator.divide(1F, 0F) }
            .withMessageContaining("0으로 나눌 수 없습니다.")
    }

    @Test
    fun `입력값이 빈 공백 문자열인 경우 에러가 발생한다`() {
        assertThatIllegalArgumentException()
            .isThrownBy { stringCalculator.calculate("   ") }
            .withMessageContaining("문자열이 비어있습니다.")
    }

    @Test
    fun `올바르지 않은 표현식은 에러가 발생한다`() {
        val invalidExpression1 = "2 + 3 * 4 ? 2"

        assertThatIllegalArgumentException()
            .isThrownBy { stringCalculator.calculate(invalidExpression1) }
            .withMessageContaining("숫자와 기호외의 문자가 포함되었습니다.")

        val invalidExpression2 = "2 + 3 * 4 + 2 +"

        assertThatIllegalArgumentException()
            .isThrownBy { stringCalculator.calculate(invalidExpression2) }
            .withMessageContaining("숫자는 기호보다 1개 많아야 합니다.")
    }

    @Test
    fun `모든 사칙연산 기호를 포함하는 경우 테스트`() {
        val expression = "2 + 3 * 4 / 2 - 5"
        val result = stringCalculator.calculate(expression)

        assertThat(result).isEqualTo(5F)
    }
}
