package study

import StringCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    @Test
    fun `덧셈 테스트`() {
        val plusTest = StringCalculator("1 + 2 + 3 + 4").calculating()
        assertThat(plusTest).isEqualTo(10)
    }

    @Test
    fun `뺄셈 테스트`() {
        val minusTest = StringCalculator("10 - 1 - 5").calculating()
        assertThat(minusTest).isEqualTo(4)
    }

    @Test
    fun `곱셈 테스트`() {
        val multiTest = StringCalculator("10 * 1 * 1 * 2").calculating()
        assertThat(multiTest).isEqualTo(20)
    }

    @Test
    fun `나눗셈 테스트`() {
        val divideTest = StringCalculator("20 / 1 / 1 / 5").calculating()
        assertThat(divideTest).isEqualTo(4)
    }

    @Test
    fun `복합 테스트`() {
        val complexTest = StringCalculator("20 * 1 + 1 - 7 / 2 + 3 / 5 - 1").calculating()
        assertThat(complexTest).isEqualTo(1)
    }

    @Test
    fun `사직연산 예외 테스트`() {
        assertThrows<IllegalArgumentException> { StringCalculator("1 z 2 - 0 + 0").calculating() }
    }

    @Test
    fun `숫자가 없는 사직연산 예외 테스트`() {
        assertThrows<IllegalArgumentException> { StringCalculator("1 + 2 + 3 + 4 + - + * / + + +").calculating() }
    }

    @Test
    fun `Null 테스트`() {
        assertThrows<IllegalArgumentException> { StringCalculator(null).calculating() }
    }

    @Test
    fun `공백 테스트`() {
        assertThrows<IllegalArgumentException> { StringCalculator("").calculating() }
        assertThrows<IllegalArgumentException> { StringCalculator(" ").calculating() }
    }
}
