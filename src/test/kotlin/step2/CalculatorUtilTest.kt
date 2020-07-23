package step2

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class CalculatorUtilTest {

    @Test
    fun `잘못된 operator`() {
        assertThatIllegalArgumentException().isThrownBy {
            CalculatorUtil.checkInputOperator("6 * 7 ^ 3".split(" "))
        }
    }

    @Test
    fun `숫자 타입이 아닌 input`() {
        assertThatIllegalArgumentException().isThrownBy {
            CalculatorUtil.checkInputNumber("6 * 7 - A".split(" "))
        }
    }

    @Test
    fun `문자열의 길이가 홀수가 아닌 경우`() {
        assertThatIllegalArgumentException().isThrownBy {
            CalculatorUtil.validateInputSize("6 * 7 *".split(" "))
        }
    }
}
