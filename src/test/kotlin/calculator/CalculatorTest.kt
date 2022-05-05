package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = ["1 + 3, 4", "15 + 31,46"])
    fun `더하기 테스트`(input: String, expect: Double) {
        val stringCalculator1 = StringCalculator(input)
        val result1 = stringCalculator1.result
        assertThat(result1).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 - 3, -2", "15 - 31,-16"])
    fun `빼기 테스트`(input: String, expect: Double) {
        val stringCalculator1 = StringCalculator(input)
        val result1 = stringCalculator1.result
        assertThat(result1).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 / 3, 0.3333333333333333", "15 / 31,0.4838709677419355"])
    fun `나누기 테스트`(input: String, expect: Double) {
        val stringCalculator1 = StringCalculator(input)
        val result1 = stringCalculator1.result
        assertThat(result1).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 * 3,3", "15 * 31,465"])
    fun `곱하기 테스트`(input: String, expect: Double) {
        val stringCalculator1 = StringCalculator(input)
        val result1 = stringCalculator1.result
        assertThat(result1).isEqualTo(expect)
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