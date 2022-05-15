package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorIntegrationTest {

    private val calculator = Calculator()

    @ParameterizedTest
    @CsvSource(
        "'1 + 1', 2",
        "'2 + 3', 5",
        "'1 - 1', 0",
        "'6 - 3', 3",
        "'2 * 3', 6",
        "'3 * 3', 9",
        "'5 * 3 / 6 + 10 - 5', 7"
    )
    fun `정상적인 수식일 경우 올바른 결과를 반환해야한다`(statement: String, answer: Long) {
        assertEquals(calculator.calculate(statement), answer)
    }

    @Test
    fun `빈 수식을 입력했을 땐, IllegalArgumentException 에러를 발생시킨다`() {
        assertThrows<IllegalArgumentException> { calculator.calculate("") }
    }

    @Test
    fun `적절치않은 연산자가 들어가면, IllegalArgumentException 에러를 발생시킨다`() {
        assertThrows<IllegalArgumentException> { calculator.calculate("1 ^ 1") }
    }
}
