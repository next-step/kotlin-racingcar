package study.stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import stringcalculator.StringCalculator
import java.lang.IllegalArgumentException

class StringCalculatorTest {

    var sc: StringCalculator = StringCalculator()

    @Test
    fun calculatorTest() {
        val input1 = "2 + 3 * 4 / 2"
        assertThat(sc.calculate(input1)).isEqualTo(10)

        val input2 = "4 + 5 * 2 / 3"
        assertThat(sc.calculate(input2)).isEqualTo(6)
    }

    @Test
    fun `잘못된 입력 예외 테스트`() {
        val input = "2 & 3 * 4"
        assertThrows<IllegalArgumentException> {
            sc.calculate(input)
        }
    }

    @Test
    fun `나눌수 없는 값 발생 시 예외`() {
        val input = "2 & 3 / 0"
        assertThrows<IllegalArgumentException> {
            sc.calculate(input)
        }
    }

    @Test
    fun `빈값 입력 시 예외`() {
        val input = ""
        assertThrows<IllegalArgumentException> {
            sc.calculate(input)
        }
    }
}
