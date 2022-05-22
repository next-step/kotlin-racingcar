package calculator

import calculator.enum.Operator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class OperatorTest {
    @Test
    fun `덧셈 연산자는 두 숫자를 더한다`() {
        val sut = Operator.PLUS
        val actual = sut.calculate(2, 1)
        assertEquals(3, actual)
    }

    @Test
    fun `뺄셈 연산자는 두 숫자를 뺄셈한다`() {
        val sut = Operator.MINUS
        val actual = sut.calculate(2, 1)
        assertEquals(1, actual)
    }

    @Test
    fun `곱셈 연산자는 두 숫자를 곱한다`() {
        val sut = Operator.MULTIPLE
        val actual = sut.calculate(2, 2)
        assertEquals(4, actual)
    }

    @Test
    fun `나눗셈 연산자는 두 숫자를 나눗셈한다`() {
        val sut = Operator.DIVIDE
        val actual = sut.calculate(2, 2)
        assertEquals(1, actual)
    }

    @ParameterizedTest
    @ValueSource(strings = ["%", "1", "", " ", "\n", "\t"])
    fun `사칙연산이 아니면 IllegalArgumentException throw`(operatorStr: String) {
        assertThrows(IllegalArgumentException::class.java) {
            Operator.findBy(operatorStr)
        }
    }
}
