package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BasicOperationsCalculatorTest {

    @ParameterizedTest()
    @CsvSource("10.0,5.0,+,15.0", "10.0,5.0,-,5.0",  "10.0,5.0,*,50.0",  "10.0,5.0,/,2.0")
    fun operation(firstNum: Double, secondNum: Double, symbol: String, expected: Double) {
        // given when
        val basicOperationsCalculator = BasicOperationsCalculator()
        val result = basicOperationsCalculator.operation(firstNum, secondNum, symbol)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
