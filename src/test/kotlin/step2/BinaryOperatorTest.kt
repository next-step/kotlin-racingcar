package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class BinaryOperatorTest {

    @Test
    fun `getOperator`() {
        val plusOpeator = BinaryOperator.getOperator("+")
        assertThat(plusOpeator(5.0, 2.0)).isEqualTo(7.0)

        val minusOperator = BinaryOperator.getOperator("-")
        assertThat(minusOperator(5.0, 2.0)).isEqualTo(3.0)

        val multiplyOperator = BinaryOperator.getOperator("*")
        assertThat(multiplyOperator(5.0, 2.0)).isEqualTo(10.0)

        val dividOperator = BinaryOperator.getOperator("/")
        assertThat(dividOperator(5.0, 2.0)).isEqualTo(2.5)

        assertThatThrownBy { BinaryOperator.getOperator("?") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("알 수 없는 연산자입니다.")

        assertThatThrownBy { BinaryOperator.getOperator("&") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("알 수 없는 연산자입니다.")

        assertThatThrownBy { BinaryOperator.getOperator(" ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("알 수 없는 연산자입니다.")
    }
}