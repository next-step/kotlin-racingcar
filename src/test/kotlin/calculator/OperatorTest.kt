package calculator

import calculator.Operator.DIVIDE
import calculator.Operator.MINUS
import calculator.Operator.PLUS
import calculator.Operator.TIMES
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun `PLUS는 덧셈 연산을 수행한다`() {
        val actual = PLUS.operate(1, 2)
        actual shouldBe 3
    }

    @Test
    fun `MINUS는 뺄셈 연산을 수행한다`() {
        val actual = MINUS.operate(1, 2)
        actual shouldBe -1
    }

    @Test
    fun `TIMES는 곱셈 연산을 수행한다`() {
        val actual = TIMES.operate(3, 2)
        actual shouldBe 6
    }

    @Test
    fun `DIVIDE는 0으로 나누려하는 경우 예외가 발생한다`() {
        val exception = shouldThrowExactly<IllegalArgumentException> { DIVIDE.operate(6, 0) }
        exception.message shouldBe "숫자는 0으로 나눌 수 없다."
    }

    @Test
    fun `DIVIDE는 나눗셈 연산을 수행한다`() {
        val actual = DIVIDE.operate(6, 2)
        actual shouldBe 3
    }
}
