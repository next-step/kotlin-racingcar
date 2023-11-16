import calculator.Calculator
import calculator.Operand
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {

    private val calculator = Calculator

    // then
    @ParameterizedTest
    @MethodSource("calculatorList")
    fun 사칙연산_계산_테스트(
        input: String,
        result: Int
    ) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(Operand(result))
    }

    companion object {
        @JvmStatic
        fun calculatorList() = listOf(
            Arguments.of("1 + 3 + 5", 9),
            Arguments.of("1 - 3 - 5", -7),
            Arguments.of("10 + 30 + 60", 100),
            Arguments.of("30 / 5 * 2", 12)
        )
    }
}

class CalculatorExceptionTest {
    private val calculator = Calculator

    @Test
    fun 빈공백_문자_입력하는_경우() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate(" ")
        }
    }

    @Test
    fun 사칙연산_기호가_아닌_경우() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate("3 # 5")
        }
    }

    @Test
    fun 사칙연산_기호가_아닌_경우2() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate("10 & -1")
        }
    }

    @Test
    fun 완성되지_않은_수식() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate("20 * 1 -")
        }
    }

}
