package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    /*
    설계.
    1) 문자열을 공백으로 나눈후 역순으로 스택에 넣는다.
    2) 스택에서 값을 순차적으로 꺼내 계산한다. (operand1, operator, operand2)
     2-1) operator 의 경우 문자열로부터 두 값을 파라미터로 받아 연산 결과를 돌려주는 함수를 반환하는 함수다.
     */

    @Test
    fun `calculate`() {
        val calculator = StringCalculator()

        assertThat(calculator.calcaulte("2 + 3 * 4 / 2")).isEqualTo(10.0)

        assertThat(calculator.calcaulte("2 - 3 * 4 / 2")).isEqualTo(-2.0)

        assertThat(calculator.calcaulte("2 + 3 * 4 / 0")).isEqualTo(Double.POSITIVE_INFINITY)

        assertThatThrownBy { calculator.calcaulte("2 - 3 * 4 / 2 *") }
            .isInstanceOf(NoSuchElementException::class.java)
            .hasMessageContaining("ArrayDeque is empty.")
    }
}