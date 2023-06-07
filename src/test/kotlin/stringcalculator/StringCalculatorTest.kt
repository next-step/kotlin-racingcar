package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("StringCalculator 클래스는")
class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource("1 + 1,2","2 - 1,1", "4 * 2,8", "4 / 2,2", "2 + 3 * 4 / 2,10")
    fun `calculate 메서드는 유효한 인자를 전달할 경우 계산 결과를 반환한다`(input: String, expected:Int) {
        val actual = StringCalculator.calculate(input)

        assertThat(actual).isEqualTo(Number(expected))
    }
}