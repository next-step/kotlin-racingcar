package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream
import kotlin.math.exp

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = ["1 + 3, 4", "15 + 31,46"])
    fun `더하기 테스트`(input: String, expect: Double) {
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculateExpression(input)
        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 - 3, -2", "15 - 31,-16"])
    fun `빼기 테스트`(input: String, expect: Double) {
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculateExpression(input)
        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @MethodSource("provideStringForDivide")
    fun `나누기 테스트`(input: String, expect: Double) {
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculateExpression(input)
        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 * 3,3", "15 * 31,465"])
    fun `곱하기 테스트`(input: String, expect: Double) {
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculateExpression(input)
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `조합 연산 테스트`() {
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculateExpression("1 * 3 + 10 / 3 - 5")
        var expectedResult: Double = 1 * 3.0
        expectedResult += 10
        expectedResult /= 3
        expectedResult -= 5
        assertThat(result).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\n"])
    fun `입력 값이 빈칸인 경우 예외를 던짐`(inputString: String) {
        assertThrows<IllegalArgumentException> {
            val stringCalculator = StringCalculator()
            stringCalculator.calculateExpression(inputString)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 = 3", "1 ! 3", "1 @ 3", "1 # 3", "1 @ 3", "1 + 3 + 5 & 10"])
    fun `사칙연산 기호 테스트`(inputString: String) {
        assertThrows<IllegalArgumentException> {
            val stringCalculator = StringCalculator()
            stringCalculator.calculateExpression(inputString)
        }
    }

    @ParameterizedTest
    @MethodSource("provideInputForOperatorTest")
    fun `연산자 테스트`(a: Double, operatorString: String, b: Double, expect: Double) {
        val operation = Operator.getCalculateLogic(operatorString)
        val result = operation(a, b)
        assertThat(result).isEqualTo(expect)
    }

    companion object {
        @JvmStatic
        private fun provideStringForDivide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 / 3", 1 / 3.0),
                Arguments.of("15 / 31", 15 / 31.0)
            )
        }

        @JvmStatic
        private fun provideInputForOperatorTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, "+", 3, 4.0),
                Arguments.of(1, "-", 3, -2.0),
                Arguments.of(1, "*", 3, 3.0),
                Arguments.of(1, "/", 3, 1 / 3.0),
            )
        }
    }
}
