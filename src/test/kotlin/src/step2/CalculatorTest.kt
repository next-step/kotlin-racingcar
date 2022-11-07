package src.step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `연산자가 없을때`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy{
                StringCalculator.execute("1234")
            }.withMessage("연산자가 포함되지 않았습니다")
    }

    @Test
    fun `값이 입력되지 않았을 때`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy{
                StringCalculator.execute("")
            }.withMessage("값이 입력되지 않았습니다")
    }

    @Test
    fun `계산기 값이 올바르게 출력되는지`() {
        Assertions.assertThat(StringCalculator.execute("2+2")).isEqualTo(4)
        Assertions.assertThat(StringCalculator.execute("2/2")).isEqualTo(1)
        Assertions.assertThat(StringCalculator.execute("1+2/3-4")).isEqualTo(-3)
    }
}