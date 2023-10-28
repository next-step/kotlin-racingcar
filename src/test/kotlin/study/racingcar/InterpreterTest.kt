package study.racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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
        assertEquals(1, interpreter.interpret("1"))
        assertThrows(IllegalOperationException::class.java) { interpreter.interpret("1+") }
    }
}
