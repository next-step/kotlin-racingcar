package step2

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

/**
 * 문자열 사칙 연산 계산기 테스트
 * Created by Jaesungchi on 2022.05.05..
 */

class StringCalculatorTest {
    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException`() {
        val calculator = StringCalculator()
        assertThatIllegalArgumentException().isThrownBy {
            calculator.startCalculate(null)
            calculator.startCalculate("")
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException`() {
        val calculator = StringCalculator()
        assertThatIllegalArgumentException().isThrownBy {
            calculator.startCalculate("2 [ 3")
            calculator.startCalculate("2 $ 3")
        }
    }
}