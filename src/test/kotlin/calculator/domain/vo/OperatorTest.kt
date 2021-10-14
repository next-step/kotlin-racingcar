package calculator.domain.vo

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@DisplayName("연산자(Operator)")
class OperatorTest {
    @Test
    fun `연산자를 올바르게 불러온다`() {
        assertAll(
            { assertThat(Operator.symbolOf("+")).isEqualTo(Operator.PLUS) },
            { assertThat(Operator.symbolOf("-")).isEqualTo(Operator.MINUS) },
            { assertThat(Operator.symbolOf("*")).isEqualTo(Operator.TIMES) },
            { assertThat(Operator.symbolOf("/")).isEqualTo(Operator.DIVIDE) },
        )
    }

    @Test
    fun `잘못된 연산자는 예외를 발생시킨다`() {
        assertThatThrownBy { Operator.symbolOf("a") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("잘못된 연산자입니다.")
    }

    @Test
    fun `0으로 나누는 경우 예외를 발생시킨다`() {
        assertThatThrownBy { Operator.DIVIDE.lambda(1.0, 0.0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("0으로 나눌 수 없습니다.")
    }
}
