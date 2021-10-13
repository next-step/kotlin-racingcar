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
}
