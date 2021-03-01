package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperationTest {
    @Test
    fun `Plus는 Args끼리 더해져야 한다`() {
        val first = 3
        val second = 5
        val except = first + second

        val result: Int = Operation.PLUS.calc(first, second)

        assertThat(result)
            .isEqualTo(except)
    }

    @Test
    fun `Minus Args끼리 빼져야 한다`() {
        val first = 3
        val second = 5
        val except = first - second

        val result: Int = Operation.MINUS.calc(first, second)

        assertThat(result)
            .isEqualTo(except)
    }

    @Test
    fun `Multiple Args끼리 곱해져야 한다`() {
        val first = 3
        val second = 5
        val except = first * second

        val result: Int = Operation.MULTIPLE.calc(first, second)

        assertThat(result)
            .isEqualTo(except)
    }

    @Test
    fun `Divide Args끼리 나눠져야 한다`() {
        val first = 10
        val second = 2
        val except = first / second

        val result: Int = Operation.DIVIDE.calc(first, second)

        assertThat(result)
            .isEqualTo(except)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `사칙 연산은 정상적인 Operation을 가져와야 한다`(input: String) {
        val operation = Operation.operationOf(input)

        assertThat(operation)
            .isNotNull()
    }

    @Test
    fun `없는 연산자는 Exception이 나와야 한다`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Operation.operationOf("@") }
    }
}
