package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class StringCalculatorTest {

    private val stringCalculator = StringCalculator()

    @Test
    @DisplayName("입력 값이 null 이거나 공백일 경우 IllegalArgumentException 오류")
    fun error1() {
        val input = null
        assertThrows<IllegalArgumentException> { stringCalculator.calculateString(input) }
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException 오류")
    fun error2() {
        val input = "( 1 + 2 - 3 ) * 4 / 5"
        assertThrows<IllegalArgumentException> { stringCalculator.calculateString(input) }
    }

    @Test
    @DisplayName("올바른 수식이 아닌 경우 IllegalArgumentException 오류")
    fun error3() {
        val input = "- -1 + 2 - 3 * 4 / 5"
        assertThrows<IllegalArgumentException> { stringCalculator.calculateString(input) }
    }

    @Test
    @DisplayName("올바른 수식이 아닌 경우 IllegalArgumentException 오류")
    fun error4() {
        val input = "-1 + 2 - 3 * 4 / 5 -"
        assertThrows<IllegalArgumentException> { stringCalculator.calculateString(input) }
    }
    @Test
    @DisplayName("0으로 나눌 경우 IllegalArgumentException 오류")
    fun error5() {
        val input = "-1 + 2 - 3 * 4 / 0"
        assertThrows<IllegalArgumentException> { stringCalculator.calculateString(input) }
    }

    @Test
    @DisplayName("100 + 200은 300이다")
    fun expression1() {
        val input = "100 + 200"
        assertThat(stringCalculator.calculateString(input)).isEqualTo(BigDecimal("300"))
    }

    @Test
    @DisplayName("100 - 200은 -100이다")
    fun expression2() {
        val input = "100 - 200"
        assertThat(stringCalculator.calculateString(input)).isEqualTo(BigDecimal("-100"))
    }

    @Test
    @DisplayName("10 * 20은 200이다")
    fun expression3() {
        val input = "10 * 20"
        assertThat(stringCalculator.calculateString(input)).isEqualTo(BigDecimal("200"))
    }

    @Test
    @DisplayName("100 / 200은 0.5이다")
    fun expression4() {
        val input = "100 / 200"
        assertThat(stringCalculator.calculateString(input)).isEqualTo(BigDecimal("0.5"))
    }

    @Test
    @DisplayName("2 + 3 * 4 / 2 - 3은 7이다")
    fun expression5() {
        val input = "2 + 3 * 4 / 2 - 3"
        assertThat(stringCalculator.calculateString(input)).isEqualTo(BigDecimal("7"))
    }
}
