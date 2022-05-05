package calculator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `입력값이 null인 경우 에러가 발생한다`() {
        // given
        val nullInput = null

        // then
        assertThatThrownBy {
            Calculator(nullInput)
        }
    }

    @Test
    fun `입력값이 공백인 경우 에러가 발생한다`() {
        // given
        val spaceInput = "    "

        // then
        assertThatThrownBy {
            Calculator(spaceInput)
        }
    }

    @Test
    fun `입력값에 사칙연산이 아닌 기호가 포함된 경우 에러가 발생한다`() {
        // given
        val input = "1 + 1 _@!#"

        // then
        assertThatThrownBy {
            Calculator(input)
        }
    }

    @Test
    fun `입력값에 연산자가 연속으로 두번 나온 경우 에러가 발생한다`() {
        // given
        val input = "1++1"

        // then
        assertThatThrownBy {
            Calculator(input)
        }
    }

    @Test
    fun `2 + 3 * 4  ÷ 2 를 입력하면 10이 나온다`() {
        // given
        val input = "2 + 3 * 4  / 2"

        // when
        Calculator(input)

        // then
    }

    @Test
    fun `공백이 포함된 입력 값인 "1  +  1   " 이 입력된 경우 2가 나온다`() {
        // given
        val input = "1  +  1   "

        // when
        Calculator(input)

        // then
    }
}
