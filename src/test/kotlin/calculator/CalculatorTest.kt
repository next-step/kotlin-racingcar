package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @Test
    fun `더하기만 테스트`() {
        val stringCalculator1 = StringCalculator("1 + 3")
        val result1 = stringCalculator1.result
        assertThat(result1).isEqualTo((1 + 3).toDouble())

        val stringCalculator2 = StringCalculator("15 + 31")
        val result2 = stringCalculator2.result
        assertThat(result2).isEqualTo((15 + 31).toDouble())
    }

    @Test
    fun `빼기만 테스트`() {
        val stringCalculator1 = StringCalculator("1 - 3")
        val result1 = stringCalculator1.result
        assertThat(result1).isEqualTo((1 - 3).toDouble())

        val stringCalculator2 = StringCalculator("15 - 31")
        val result2 = stringCalculator2.result
        assertThat(result2).isEqualTo((15 - 31).toDouble())
    }

    @Test
    fun `나누기 테스트`() {
        val stringCalculator1 = StringCalculator("1 / 3")
        val result1 = stringCalculator1.result
        assertThat(result1).isEqualTo((1 / 3.0))

        val stringCalculator2 = StringCalculator("15 / 31")
        val result2 = stringCalculator2.result
        assertThat(result2).isEqualTo((15 / 31.0))
    }

    @Test
    fun `곱하기 테스트`() {
        val stringCalculator1 = StringCalculator("1 * 3")
        val result1 = stringCalculator1.result
        assertThat(result1).isEqualTo((1 * 3).toDouble())

        val stringCalculator2 = StringCalculator("15 * 31")
        val result2 = stringCalculator2.result
        assertThat(result2).isEqualTo((15 * 31).toDouble())
    }

    @Test
    fun `조합 연산 테스트`() {
        val stringCalculator = StringCalculator("1 * 3 + 10 / 3 - 5")
        val result1 = stringCalculator.result
        var expectedResult: Double = 1 * 3.0
        expectedResult += 10
        expectedResult /= 3
        expectedResult -= 5
        assertThat(result1).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\n"])
    fun `빈칸 테스트`(inputString: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                val stringCalculator = StringCalculator(inputString)
                println(stringCalculator.result)
            }.withMessageContaining(StringCalculator.BLANK_ERROR_MSG)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 = 3", "1 ! 3", "1 @ 3", "1 # 3", "1 @ 3", "1 + 3 + 5 & 10"])
    fun `사칙연산 기호 테스트`(inputString: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                val stringCalculator = StringCalculator(inputString)
                println(stringCalculator.result)
            }.withMessage(StringCalculator.WIERD_OPERATOR_ERROR_MSG)
    }
}