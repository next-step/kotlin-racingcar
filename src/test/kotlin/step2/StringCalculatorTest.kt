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

    val calculator = StringCalculator()

    @Test
    fun `parse`() {
        val expected = listOf("2", "+", "3", "*", "4", "/", "2")
        assertThat(calculator.parse("2 + 3 * 4 / 2")).isEqualTo(expected)

        assertThat(calculator.parse("2 + 3 * 4 / 2")).isEqualTo(expected)

        assertThatThrownBy { calculator.parse(null) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 null 이거나 빈 공백 문자입니다.")

        assertThatThrownBy { calculator.parse("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 null 이거나 빈 공백 문자입니다.")

        assertThatThrownBy { calculator.parse("  ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 null 이거나 빈 공백 문자입니다.")
    }

    @Test
    fun `getOperator`() {
        val plusOpeator = calculator.getOperator("+")
        assertThat(plusOpeator(5.0, 2.0)).isEqualTo(7.0)

        val minusOperator = calculator.getOperator("-")
        assertThat(minusOperator(5.0, 2.0)).isEqualTo(3.0)

        val multiplyOperator = calculator.getOperator("*")
        assertThat(multiplyOperator(5.0, 2.0)).isEqualTo(10.0)

        val dividOperator = calculator.getOperator("/")
        assertThat(dividOperator(5.0, 2.0)).isEqualTo(2.5)

        assertThatThrownBy { calculator.getOperator("?") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("알 수 없는 연산자입니다.")

        assertThatThrownBy { calculator.getOperator("&") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("알 수 없는 연산자입니다.")

        assertThatThrownBy { calculator.getOperator(" ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("알 수 없는 연산자입니다.")
    }

    @Test
    fun `calculate`() {
        assertThat(calculator.calcaulte("2 + 3 * 4 / 2")).isEqualTo(10.0)

        assertThat(calculator.calcaulte("2 - 3 * 4 / 2")).isEqualTo(-2.0)

        assertThat(calculator.calcaulte("2 + 3 * 4 / 0")).isEqualTo(Double.POSITIVE_INFINITY)

        assertThatThrownBy { calculator.calcaulte("2 - 3 * 4 / 2 *") }
            .isInstanceOf(NoSuchElementException::class.java)
            .hasMessageContaining("ArrayDeque is empty.")
    }
}