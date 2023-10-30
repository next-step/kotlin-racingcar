package calculator.unit

import calculator.Operand
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperandTest {

    @Test
    fun `피연산자를 가져온다`() {
        val operand = Operand.from("1")
        assertEquals(operand.getValue(), 1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "1 2", "+"])
    fun `피연산자가 아닌 값이 들어오면 예외가 발생한다`(value: String) {
        assertThrows(IllegalArgumentException::class.java) {
            Operand.from(value)
        }
    }
}
