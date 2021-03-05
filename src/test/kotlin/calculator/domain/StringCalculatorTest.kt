package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class StringCalculatorTest {

    @Test
    @DisplayName("Calculator를 생성하고, 연산을 수행하면 올바른 결과를 낸다")
    fun spaceCalculator() {
        val stringCalculator = StringCalculator()

        val result1 = stringCalculator.calculate("1 + 3")
        val result2 = stringCalculator.calculate("1 * 3")

        assertThat(result1).isEqualTo(4.0)
        assertThat(result2).isEqualTo(3.0)
    }

    @Test
    @DisplayName("#을 delimeter로 한 Caculator를 생성해 연산을 수행할 수 있다.")
    fun poundCalculator() {
        val stringCalculator = StringCalculator("#")

        val result = stringCalculator.calculate("1#+#3")

        assertThat(result).isEqualTo(4.0)
    }
}
