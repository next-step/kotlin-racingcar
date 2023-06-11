package study.step2

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OperatorTests {

    @Test
    fun `0으로 나누는 경우 ArithmeticException 이 발생한다`() {
        assertThrows<ArithmeticException> {
            Operator.DIVISION.operation(1, 0)
        }
    }
}
