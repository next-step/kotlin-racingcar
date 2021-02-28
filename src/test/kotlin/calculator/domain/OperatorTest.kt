package calculator.domain

import calculator.calculator.domain.Operator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class OperatorTest {
    @DisplayName("연산자의 기호를 입력한 경우 해당 Operator 반환")
    @Test
    fun from() {
        assertThat(Operator.from("+")).isEqualTo(Operator.ADD)
    }

    @DisplayName("존재하지 않는 기호를 입력한 경우 예외 반환")
    @Test
    fun from_exception() {
        assertThatThrownBy { Operator.from("a") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("두 수를 인자로 받아 해당 연산자의 계산 결과 반환")
    @Test
    fun calculate() {
        assertThat(Operator.ADD.calculate(2.0, 3.0)).isEqualTo(5.0)
    }
}
