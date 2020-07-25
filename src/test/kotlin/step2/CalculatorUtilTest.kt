package step2

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class CalculatorUtilTest {

    val DELIMITER = " "

    @Test
    fun `잘못된 operator인 경우 operator validation 시 IllegalArgumentException 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            CalculatorUtil.checkInputOperator("6 * 7 ^ 3".split(DELIMITER))
        }
    }

    @Test
    fun `숫자 타입이 아닌 경우 data validation 시 IllegalArgumentException 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            CalculatorUtil.checkInputNumber("6 * 7 - A".split(DELIMITER))
        }
    }

    @Test
    fun `문자열의 길이가 짝수인 경우 data validation 시 IllegalArgumentException 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            CalculatorUtil.validateInputSize("6 * 7 *".split(DELIMITER))
        }
    }

    @Test
    fun `문자열의 길이가 1인 경우 data validation 시 IllegalArgumentException 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            CalculatorUtil.validateInputSize("6".split(DELIMITER))
        }
    }

    @Test
    fun `입력값이 빈 경우 validation 시 exception 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            CalculatorUtil.validateEmptyData(" ")
        }.withMessage("input data 가 비어있습니다.")
    }
}
