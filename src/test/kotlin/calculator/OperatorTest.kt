package calculator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `사칙연산 - 덧셈`() {
        Assertions.assertEquals(Operator.PLUS.calculate(7428934, 189248), 7618182)
    }

    @Test
    fun `사칙연산 - 뺄셈`() {
        Assertions.assertEquals(Operator.MINUS.calculate(45, 90), -45)
    }

    @Test
    fun `사칙연산 - 곱셈`() {
        Assertions.assertEquals(Operator.MULTIPLY.calculate(25, 2), 50)
    }

    @Test
    fun `사칙연산 - 나눗셈`() {
        Assertions.assertEquals(Operator.DIVIDE.calculate(100, 2), 50)
    }
}