import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @Test
    fun `문자열 자르기`() {

        val input = "1234-5678-9000"

        val substringBefore = input.substringBefore("-")
        val substringAfter = input.substringAfter("-")

        assertThat(substringBefore).isEqualTo("1234")
        assertThat(substringAfter).isEqualTo("5678-9000")
    }

    @Test
    fun `인덱스 가져오기`() {

        var input = "2 + 3 * 4 / 2"
        input = input.replace(" ", "")
        val index = input.indexOfFirst { c -> Operator.PLUS.equals(c) }
        assertThat(index).isEqualTo(1)
    }

    @Test
    fun `덧셈`() {
        val input = "2 + 3"
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculate(input)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `뺄셈`() {

        val input = "3 - 2"
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculate(input)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `곱셈`() {

        val input = "2 * 4"
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculate(input)
        assertThat(result).isEqualTo(8)
    }

    @Test
    fun `나눗셈`() {

        val input = "4 / 2"
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculate(input)
        assertThat(result).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `입력값이 null 이거나 빈 공백문자 일경우`(input: String) {

        val stringCalculator = StringCalculator()

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @Test
    fun `사칙연산 기호가 아닌경우`() {

        val input = "2 ! 3 * 4 / 2"
        val stringCalculator = StringCalculator()
        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @Test
    fun `사칙연산 기능 구현`() {

        val input = "2 + 3 * 4 / 2"
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculate(input)

        assertThat(result).isEqualTo(10)
    }
}
