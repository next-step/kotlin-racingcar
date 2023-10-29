package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {
    @ParameterizedTest
    @CsvSource(
        "+ , 3",
        "-, -1",
        "*, 2",
        "/, 0",
    )
    fun `사칙 연산자 정상 동작 확인`(input: String, expected: String) {
        // given
        val operand1 = "1"
        val operand2 = "2"

        // when
        val result = Operator.fromSymbol(input).calcFunc(operand1.toInt(), operand2.toInt()).toString()

        // then
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(
        "^",
        "$",
        "#",
        "//"
    )
    fun `지원하지 않는 연산자가 들어왔을 경우 IllegalArgumentException가 발생`(input: String) {
        // given - input
        assertThrows<IllegalArgumentException> {
            Operator.fromSymbol(input).calcFunc(1, 2).toString()
        }.also {
            assertEquals("지원하지 않는 연산자가 들어왔다.", it.message)
        }
    }

}
