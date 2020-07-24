import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class CalculatorTest {
    @DisplayName("계산기 테스트")
    @Test
    fun calculate() {
        val calculator = Calculator()
        val input = listOf<String>("4", "+", "4", "/", "2", "*", "2")
        val calcValue = calculator.calc(input)

        assert(calcValue == 8.0)
    }

    @DisplayName("계산기 비 정상 테스트")
    @Test
    fun calculateExcept() {
        val calculator = Calculator()

        val inputOne = listOf<String>("4")
        val oneValue = calculator.calc(inputOne)
        assert(oneValue == 4.0)

        val inputOperate = listOf<String>("+")
        assertThrows<IllegalArgumentException> {
            calculator.calc(inputOperate)
        }

        val inputTwo = listOf<String>("4", "-")
        val twoValue = calculator.calc(inputTwo)
        assert(twoValue == 4.0)
    }
}
