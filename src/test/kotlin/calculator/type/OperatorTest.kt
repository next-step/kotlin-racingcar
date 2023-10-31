package calculator.type

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun `더하기`() {
        val operator = Operator.of("+")
        val result = operator.operationFunction(3, 2)
        assertEquals(5, result)
    }

    @Test
    fun `빼기`() {
        val operator = Operator.of("-")
        val result = operator.operationFunction(3, 2)
        assertEquals(1, result)
    }

    @Test
    fun `곱하기`() {
        val operator = Operator.of("*")
        val result = operator.operationFunction(3, 2)
        assertEquals(6, result)
    }

    @Test
    fun `나누기`() {
        val operator = Operator.of("/")
        val result = operator.operationFunction(3, 2)
        assertEquals(1, result) // 결과는 int 이므로 1.5 가 아닌 1 이 나옴
    }

    @Test
    fun `사칙연산 이외의 연산은 NONE`() {
        val operator = Operator.of("%")
        assertEquals(Operator.NONE, operator)
    }

    @Test
    fun `NONE인 경우, 왼쪽 피연산자를 그대로 반환`() {
        val operator = Operator.NONE
        val result = operator.operationFunction(3, 2)
        assertEquals(3, result)
    }
}
