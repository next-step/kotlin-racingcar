package calculator

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class CalculatorTest {

    @Test
    fun `Calculator에 같은 연산자가 두개 이상 존재하면 OperatorAlreadyExistException 예외 발생`() {
        // when
        val executable = Executable {
            TestCalculator(
                listOf(TestOperator(), TestOperator())
            )
        }

        // then
        assertThrows(OperatorAlreadyExistException::class.java, executable)
    }
}
