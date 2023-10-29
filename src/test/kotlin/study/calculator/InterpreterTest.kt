package study.calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.calculator.IllegalOperationException
import study.calculator.Interpreter
import study.calculator.Parser

class InterpreterTest {
    @ParameterizedTest
    @ValueSource(strings = ["1 +", "1 + 2 2", "1 + 2 +", "+", "+ 1", "1+"])
    fun `계산 가능한 문자열인지 확인`(input: String) {
        val interpreter = Interpreter(Parser())
        assertThrows(IllegalOperationException::class.java) { interpreter.checkSemantic(input) }
    }

    @Test
    fun `계산기 결과 확인`() {
        val interpreter = Interpreter(Parser())
        assertEquals(3, interpreter.interpret("1 + 2"))
    }

    @Test
    fun `Interpreter 의 interpret 이 계산 불가능한 문자열을 검출하는 역할을 checkSemantic 에게 정상 할당하는지 확인 `() {
        val interpreter = Interpreter(Parser())
        assertThrows(IllegalOperationException::class.java) { interpreter.checkSemantic("1 + 2 + ") }
    }
}
