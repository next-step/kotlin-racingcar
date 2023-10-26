package study.racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class InterpreterTest {
    @Test
    fun `계산 가능한 문자열인지 확인`() {
        val interpreter = Interpreter(Parser())
        assertThrows(IllegalOperationException::class.java) { interpreter.semanticAnalysis("1 +") }
        assertThrows(IllegalOperationException::class.java) { interpreter.semanticAnalysis("1 + 2 2") }
        assertThrows(IllegalOperationException::class.java) { interpreter.semanticAnalysis("1 + 2 +") }
        assertThrows(IllegalOperationException::class.java) { interpreter.semanticAnalysis("+") }
        assertThrows(IllegalOperationException::class.java) { interpreter.semanticAnalysis("+ 1") }
        assertThrows(IllegalOperationException::class.java) { interpreter.semanticAnalysis("1+") }
        // assertThrows(IllegalOperationException::class.java) { interpreter.semanticAnalysis("+1") }
    }

    @Test
    fun `계산기 결과 확인`() {
        val interpreter = Interpreter(Parser())
        assertEquals(3, interpreter.interpret("1 + 2"))
        assertEquals(1, interpreter.interpret("1"))
        assertThrows(IllegalArgumentException::class.java) { interpreter.interpret("1+") }
    }
}
