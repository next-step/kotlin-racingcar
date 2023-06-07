package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import stringcalculator.config.CalculatorConfig

@DisplayName("StringCalculator 클래스의")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringCalculatorTest {

    private val stringCalculator: StringCalculator = CalculatorConfig.stringCalculator

    @ParameterizedTest
    @CsvSource("1 + 1,2", "2 - 1,1", "4 * 2,8", "4 / 2,2", "2 + 3 * 4 / 2,10")
    fun `calculate 메서드는 유효한 인자를 전달할 경우 계산 결과를 반환한다`(input: String, expected: Double) {
        val actual = stringCalculator.calculate(input)

        assertThat(actual).isEqualTo(Number(expected))
    }

    @ParameterizedTest
    @CsvSource("1 + 2 * 2, 6", "2 * 2 + 1, 5")
    fun `calculate 메서드는 입력 값에 따라 계산 순서가 결정된다`(input: String, expected: Double) {
        val actual = stringCalculator.calculate(input)

        assertThat(actual).isEqualTo(Number(expected))
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `calculate 메서드는 공백이나 Null 인자 전달시 예외를 던진다`(input: String?) {
        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @Test
    fun `calculate 메서드는 0으로 나누려 하는 인자 전달시 예외를 던진다`() {
        assertThrows<ArithmeticException> {
            stringCalculator.calculate("5 / 0")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1+1", "+ 1 / 3", "1+4/", "3 +- 7", "3 + 8 -", "4 + 4 4"])
    fun `calculate 메서드는 유효하지 않은 인자 전달시 예외를 던진다`(input: String) {
        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }
}
