package calculator

import calculator.Operator.DIVIDE
import calculator.Operator.MINUS
import calculator.Operator.PLUS
import calculator.Operator.TIMES
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @CsvSource(value = ["+, PLUS", "-, MINUS", "*, TIMES", "/, DIVIDE"])
    fun `연산자 sign을 입력하면 Operator를 반환한다`(input: String, expected: Operator) {
        val actual = Operator.from(input)
        actual shouldBe expected
    }

    @ParameterizedTest
    @ValueSource(strings = ["$", "", " ", "#"])
    fun `존재하지 않는 연산자 sign을 입력하는 경우 예외가 발생한다`(input: String) {
        val exception = shouldThrowExactly<IllegalArgumentException> { Operator.from(input) }
        exception.message shouldBe "올바른 연산자를 입력하여야 한다."
    }
}
