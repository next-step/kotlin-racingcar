package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {
    @Test
    fun `+ 연산자가 있으면 PLUS OPERATOR 반환`() {
        val operator = Operator.findBy("+")
        assertThat(operator).isEqualTo(Operator.PLUS)
    }

    @Test
    fun `- 연산자가 있으면 MINUS OPERATOR 반환`() {
        val operator = Operator.findBy("-")
        assertThat(operator).isEqualTo(Operator.MINUS)
    }

    @Test
    fun `* 연산자가 있으면 TIMES OPERATOR 반환`() {
        val operator = Operator.findBy("*")
        assertThat(operator).isEqualTo(Operator.TIMES)
    }

    @Test
    fun `슬래시 연산자가 있으면 DIVIDE OPERATOR 반환`() {
        val operator = Operator.findBy("/")
        assertThat(operator).isEqualTo(Operator.DIVIDE)
    }

    @ParameterizedTest
    @CsvSource(
        "+, 110",
        "-, 90",
        "*, 1000",
        "/, 10",
    )
    fun `연산자에 따른 계산값 반환`(operatorSign: String, expected: Int) {
        val operator = Operator.findBy(operatorSign)
        val result = operator.calculate(100, 10)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 0, 100, 1000])
    fun `0 으로 나누면 IllegalArgumentException 반환`(number: Int) {
        val operator = Operator.findBy("/")
        assertThatIllegalArgumentException()
            .isThrownBy { operator.calculate(number, 0) }
    }
}