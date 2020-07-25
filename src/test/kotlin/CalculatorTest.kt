import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @Test
    fun happyCase() {
        val equation = "2+3*4/2"
        val result = Calculator.calEquation(equation)
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `사칙 연산 기호가 아닌 경우`() {
        assertThatIllegalArgumentException().isThrownBy {
            val equation = "2:3*4/2"
            Calculator.calEquation(equation)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2", "", " "])
    fun `식에 공백이 들어간 경우`(input: String) {
        assertThatIllegalArgumentException().isThrownBy {
            Calculator.calEquation(input)
        }
    }

    @Test
    fun `식이 널인 경우`() {
        assertThatIllegalArgumentException().isThrownBy {
            Calculator.calEquation(null)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2+3*", "2+3**3", "*2+3**3"])
    fun `불완전한 식을 계산할 경우`(input: String) {
        assertThatIllegalArgumentException().isThrownBy {
            Calculator.calEquation(input)
        }
    }
}
