package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BasicOperationsCalculatorTest {

    @ParameterizedTest()
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun operation(symbol: String) {
        // given
        val firstNum: Double = 10.0
        val secondNum: Double = 5.0

        // when
        val basicOperationsCalculator = BasicOperationsCalculator()
        val result = basicOperationsCalculator.operation(firstNum, secondNum, symbol)

        // then
        assertAll(
            {
                when (symbol) {
                    "+" -> assertThat(result).isEqualTo(15.0)
                    "-" -> assertThat(result).isEqualTo(5.0)
                    "*" -> assertThat(result).isEqualTo(50.0)
                    "/" -> assertThat(result).isEqualTo(2.0)
                }
            }
        )
    }
}
