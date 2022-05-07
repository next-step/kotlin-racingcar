package calculator.domain

import io.kotest.matchers.collections.shouldContainInOrder
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExpressionTests {

    @Test
    fun `입력된 문자열이 유효하다면 식으로 변환할 수 있다`() {
        val input = "1+2-3*4/5"
        assertThat(Expression.of(input)).extracting {
            it.operands.shouldContainInOrder(
                Operand(1),
                Operand(2),
                Operand(3),
                Operand(4),
                Operand(5)
            )
            it.operators.shouldContainInOrder(
                Operator.PLUS,
                Operator.MINUS,
                Operator.TIMES,
                Operator.DIVIDE,
            )
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2+", "+1+", "+1-1"])
    fun `식에 포함된 연산자와 피연산자의 개수가 유효하지 않으면 예외가 발생한다`(input: String) {
        assertThatThrownBy { Expression.of(input) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("유효하지 않은 식입니다")
    }

    @ParameterizedTest
    @ValueSource(strings = ["2+two", "1*one", "3/three"])
    fun `식에 숫자가 아닌 피연산자가 포함되면 예외가 발생한다`(input: String) {
        assertThatThrownBy { Expression.of(input) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자로 변환할 수 없는 문자입니다")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1&1", "1!1", "3^2"])
    fun `식에 사칙연산이 아닌 연산자가 포함되면 예외가 발생한다`(input: String) {
        assertThatThrownBy { Expression.of(input) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("사칙 연산이 아닌 연산자는 지원하지 않습니다")
    }
}
