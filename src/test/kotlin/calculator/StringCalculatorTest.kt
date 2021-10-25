package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource("2 + 3 + 5=10", "-1 + 5 - 4=0", "-3 + -5 + 8=0", delimiter = '=')
    fun 계산기(value: String, result: Int) {
        Assertions.assertThat(StringCalculator.calculation(value)).isEqualTo(result)
    }
}
