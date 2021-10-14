package step2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OperatorTest {

    @Test
    fun `지원하지 않는 operation 일 때 NotSupportOperationException`() {
        val arithmeticSymbol = "."
        val exception = assertThrows<NotSupportOperationException> {
            Operator.findBy(arithmeticSymbol)
        }

        assertEquals("지원하지 않는 operation 입니다. $arithmeticSymbol", exception.message)
    }

    @Test
    fun `+ 일때 ADD 인지 테스트`() {
        val result = Operator.findBy("+")
        assertEquals(Operator.ADD, result)
    }

    @Test
    fun `- 일때 SUBTRACT 인지 테스트`() {
        val result = Operator.findBy("-")
        assertEquals(Operator.SUBTRACT, result)
    }

    @Test
    fun `* 일때 MULTIPLY 인지 테스트`() {
        val result = Operator.findBy("*")
        assertEquals(Operator.MULTIPLY, result)
    }

    @Test
    @DisplayName("/ 일때 DIVISION 인지 테스트")
    fun `나누기 일때 DIVISION 인지 테스트`() {
        val result = Operator.findBy("/")
        assertEquals(Operator.DIVISION, result)
    }

    @Test
    fun `ADD operation 결과 검증`() {
        val result = Operator.ADD.operation(1.0, 2.0)
        assertEquals(3.0, result)
    }

    @Test
    fun `SUBTRACT operation 결과 검증`() {
        val result = Operator.SUBTRACT.operation(2.0, 1.0)
        assertEquals(1.0, result)
    }

    @Test
    fun `MULTIPLY operation 결과 검증`() {
        val result = Operator.MULTIPLY.operation(2.0, 3.0)
        assertEquals(6.0, result)
    }

    @Test
    fun `DIVISION operation 결과 검증`() {
        val result = Operator.DIVISION.operation(4.0, 2.0)
        assertEquals(2.0, result)
    }

    @Test
    fun `0으로 나눌 때 exception`() {
        val exception = assertThrows<IllegalArgumentException> {
            val result = Operator.DIVISION.operation(4.0, 0.0)
        }

        assertEquals("0으로 나눌 수 없습니다.", exception.message)
    }
}
