package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OperationTest {
    @Test
    fun `더하기 연산이 정상 동작한다`() {
        assertThat(Operation.ADD.apply(1, 1)).isEqualTo(2)
    }

    @Test
    fun `빼기 연산이 정상 동작한다`() {
        assertThat(Operation.SUBTRACT.apply(1, 1)).isEqualTo(0)
    }

    @Test
    fun `곱하기 연산이 정상 동작한다`() {
        assertThat(Operation.MULTIPLY.apply(3, 2)).isEqualTo(6)
    }

    @Test
    fun `나누기 연산이 정상 동작한다`() {
        assertThat(Operation.DIVIDE.apply(10, 2)).isEqualTo(5)
    }

    @Test
    fun `나누기 연산 시 분모에 0이 오면 예외가 발생한다`() {
        assertThatThrownBy {
            Operation.DIVIDE.apply(10, 0)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
