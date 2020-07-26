package onestep.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class CalculatorInputTest {

    @Test
    fun `정상적인 값을 입력한 경우, 정상값이 나와야한다`() {
        assertThat(CalculatorInputManager.calculate("1 + 3")).isEqualTo("4.0")
        assertThat(CalculatorInputManager.calculate("3 + 7 * 5")).isEqualTo("50.0")
        assertThat(CalculatorInputManager.calculate("1 - 3 / 2 * 5")).isEqualTo("-5.0")
        assertThat(CalculatorInputManager.calculate("13 + 32 - 35 * 0 / 3")).isEqualTo("0.0")
    }

    @Test
    fun `입력문자열 Blank일 경우, Exception을 던져야 한다`() {
        /*
        * Given : Blank InputString [input]
        * When : calculate
        * Then : IllegalArgumentException( Wrong Input )
        * */
        val input = " "
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CalculatorInputManager.calculate(input)
        }
    }

    @Test
    fun `입력문자열 중 입력값 사이의 Blank가 없을 때,Exception을 던져야 한다`() {
        /*
        * Given : Wrong Expression(no Blank) in InputString [input]
        * When : calculate
        * Then : IllegalArgumentException( Wrong Expression Input )
        * */
        val input = "1 +2 + 4 / 3"
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CalculatorInputManager.calculate(input)
        }
    }

    @Test
    fun `입력문자열 중 정의된 연산자가 아닌 경우, Exception을 던져야 한다`() {
        /*
        * Given : Unknown Operator in InputString [input]
        * When : calculate
        * Then : IllegalArgumentException( Unknown Operator )
        * */
        val input = "1 % 2 + 4 / 3"
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CalculatorInputManager.calculate(input)
        }
    }

    @Test
    fun `입력문자열이 잘못된 구조의 표현식일 경우, Exception을 던져야 한다`() {
        /*
        * Given : Wrong Expression(Duplication Operator) in InputString [input]
        * When : calculate
        * Then : IllegalArgumentException( Wrong Expression Input )
        * */
        val input = "1 ++ 2 + 4 / 3"
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CalculatorInputManager.calculate(input)
        }
    }
}
