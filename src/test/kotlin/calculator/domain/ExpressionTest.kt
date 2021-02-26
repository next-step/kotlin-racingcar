package calculator.domain

import calculator.calculator.domain.Expression
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ExpressionTest {
    @DisplayName("항의 개수를 잘못 입력한 경우 예외 발생")
    @Test
    fun validate() {
        assertThatThrownBy { Expression("2 + 3 *") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("숫자 위치에 다른 문자를 입력한 경우 예외 발생")
    @Test
    fun toNumbers() {
        assertThatThrownBy { Expression("2 + a") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("연산자의 기호가 아닌 다른 문자를 입력한 경우 예외 발생")
    @Test
    fun toOperators() {
        assertThatThrownBy { Expression("2 a 3") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("식의 결과 반환")
    @Test
    fun getResult() {
        assertThat(Expression("2 + 3").getResult()).isEqualTo(5.0)
    }
}